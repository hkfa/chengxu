package shili;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import mybatis.Mybatis;
import mybatis.Test;

public class Jvlei2 {
	public static void main(String[]args) throws IOException {
		Jvlei2 j=new Jvlei2();
		Map<String,Map<String,Double>>allDocMap=j.computeTFIDF();
		j.cluster(allDocMap, 4);
		System.out.println(j.cluster(allDocMap, 4));	
	}
	public Map<String ,Map<String,Double>> computeTFIDF()throws IOException{
		Mybatis mybatis=new Mybatis();
		List<Test> t=mybatis.getAllDocuments();
		KeyWordComputer k=new KeyWordComputer(3);
		Map<String,Map<String,Double>>allDocMap=new HashMap<String,Map<String,Double>>();
		for(int i=0;i<16;i++){	
			String doc=t.get(i).getTitle();	
			List<Keyword> result=k.computeArticleTfidf(doc);
			Map<String,Double> wordVector=new HashMap<String,Double>();
			for(Keyword word:result){			
				wordVector.put(word.getName(), word.getScore());			
			}
			allDocMap.put(doc, wordVector);
			//System.out.println(wordVector);
		}
		//System.out.println(allDocMap);
		return allDocMap;
	}
	
	
	public Map<String,Integer> cluster(Map<String,Map<String,Double>> allDocMap,int k){
		int count=0;
		int allDocMapSize=16;
		String[] allDocNames=new String[allDocMap.size()];
		Set<Map.Entry<String, Map<String,Double>>> allDocNamesSet=allDocMap.entrySet();
		Iterator<Map.Entry<String, Map<String,Double>>> it=allDocNamesSet.iterator();
		while(it.hasNext()){
			Map.Entry<String, Map<String,Double>> me=it.next();
			allDocNames[count++]=me.getKey();
		}
		
		Map<Integer,Map<String,Double>>meansMap=getInitPoint(allDocMap,k);
		
		double[][]distance=new double[allDocMapSize][k];
		Map<Integer,Vector<Integer>>clusterMember=new TreeMap<Integer,Vector<Integer>>();
		Vector<Integer> mem = new Vector<Integer>();
		int iterNum = 0; 
		int[] assignMeans=new int[16];
		while(true){
			for(int i=0;i<16;i++){
				for(int j=0;j<k;j++){
					String docName=allDocNames[i];
					Map<String, Double>  initVector=meansMap.get(j);
					Map<String,Double> map1=allDocMap.get(docName);
					distance[i][j]=getDistance(map1,initVector);
				}
			}
			
			int[]nearestMeans=new int[16];
			for(int j=0;j<16;j++){
				int a=findNearestMeans(distance,j);
				nearestMeans[j]=a;
			}
			int okCount = 0;
			for(int i= 0;i<16;i++){
				if(nearestMeans[i] == assignMeans[i])
					okCount ++;
			}
			
			if(okCount == 16 || iterNum >= 10)
			{	break;}
			clusterMember.clear();
			for(int i = 0;i < 16;i++){
				assignMeans[i] = nearestMeans[i];
				if(clusterMember.containsKey(nearestMeans[i])){
					clusterMember.get(nearestMeans[i]).add(i);
				}
				else{
					mem.clear();
					mem.add(i);
					Vector<Integer> tempMem = new Vector<Integer>();
					tempMem.addAll(mem);
					clusterMember.put(nearestMeans[i], tempMem);
				}
			}
			
			for(int i=0;i<k;i++){
				Map<String,Double> newMean=computeNewMean(clusterMember.get(i),allDocMap,allDocNames);
				Map<String,Double> tempMean = new TreeMap<String,Double>();
				tempMean.putAll(newMean);
			
			}
		}
		Map<String,Integer> resMap = new TreeMap<String,Integer>();
		for(int i = 0;i<16;i++){
			resMap.put(allDocNames[i], assignMeans[i]);
		}
		
		return resMap;
		
		
	}
	
	public Map<String,Double> computeNewMean(Vector<Integer>clusterM,Map<String,Map<String,Double>>allDocMap,String[]allDocNames){
		String key1;
		 double memberNum=clusterM.size();
		Map<String,Double> newMeanMap = new TreeMap<String,Double>();
		Map<String,Double> currentMemMap = new TreeMap<String, Double>();
	Iterator it=clusterM.iterator();
	while(it.hasNext()){
		int me=(Integer) it.next();
		String docName=allDocNames[me];
		currentMemMap = allDocMap.get(docName);
		Set<Map.Entry<String, Double>> currentMemMapSet = currentMemMap.entrySet();
		Iterator jt=currentMemMapSet.iterator();
		while(jt.hasNext()){
			Map.Entry<String,Double >ne=(Entry<String, Double>) jt.next();
			if(newMeanMap.containsKey(ne.getKey()))
			{	 key1=ne.getKey();
			double value1=newMeanMap.get(key1);
			double value=value1+ne.getValue();
				newMeanMap.put(ne.getKey(), value);}
			else
				newMeanMap.put(ne.getKey(), ne.getValue());
		}
	}
	
	Set<Map.Entry<String, Double>> newMeanMapSet = newMeanMap.entrySet();
	Iterator its=newMeanMapSet.iterator();
	while(its.hasNext()){
		Map.Entry<String, Double> me=(Entry<String, Double>) its.next();
		newMeanMap.put(me.getKey(), newMeanMap.get(me.getKey()) / memberNum);
		
	}
	return newMeanMap;
	
	
	}
	
	public int findNearestMeans(double[][]distance,int j){
		int m=0;
		double minDist=10;
		for(int i=0;i<4;i++){
			if(distance[j][i]<minDist){
				minDist=distance[j][i];
				m=i;
			}
			
		}
		return m;
	}
	public double getDistance(Map<String,Double>map1,Map<String,Double>map2){
		double distance=1-computeSim(map1,map2);
		return distance;
	}
	public Map<Integer,Map<String,Double>> getInitPoint(Map<String,Map<String,Double>> allDocMap,int k){
		Map<Integer,Map<String,Double>> meansMap = new TreeMap<Integer, Map<String,Double>>();
		int count=0;
		int i=0;
		Set<Map.Entry<String, Map<String,Double>>> allTestSampleMapSet = allDocMap.entrySet();
		for(Iterator<Map.Entry<String, Map<String,Double>>> it = allTestSampleMapSet.iterator();it.hasNext();){
			Map.Entry<String, Map<String,Double>> me = it.next();
			if(count == i*allTestSampleMapSet.size() / k){
				meansMap.put(i, me.getValue());
				//System.out.println(me.getKey());
				i++;
			}
			count++ ;
		}
		
		return meansMap;
	}

	
	public double computeSim(Map<String,Double>wordTFMap1,Map<String,Double>wordTFMap2 ){
		double mul=0;
		Set<Map.Entry<String,Double>> wordTFMapSet=wordTFMap1.entrySet();
		
		for(Iterator <Map.Entry<String, Double>>it =  wordTFMapSet.iterator();it.hasNext();){
			Map.Entry<String, Double>me=it.next();
			if(wordTFMap2.containsKey(me.getKey())){
				mul=mul+me.getValue()*wordTFMap2.get(me.getKey());
			}
			
		}
		return mul;

	}
	/*
	 * 
	 * 
	
	public Map<String,Map<String,Double>> ReallycomputeWordVector(){
		Double wordSumPerDoc = 50.0;
		int docSum=20;
		Map<String,Map<String,Double>> allDocMap=new HashMap<String,Map<String,Double>>();
		String []strings={"D","B","C","A","B","D","D","D","B","C"};
		//Map<String,Double> idfPerDocMap=computeIDF();
		Map<String,Double> tfPerDocMap=new HashMap<String,Double>();
		for(String word:strings){		 
			if(tfPerDocMap.containsKey(word)) {
				tfPerDocMap.put(word, tfPerDocMap.get(word)+1);
			}else {
				tfPerDocMap.put(word, 1.0);
			}
		}
		Double maxCount=0.0;
		Double wordWeight;
		Set<Map.Entry<String, Double>> tempTF = tfPerDocMap.entrySet();
		for(Iterator<Map.Entry<String, Double>> mt = tempTF.iterator();mt.hasNext();){
			Map.Entry<String, Double> me = mt.next();
			if(me.getValue() > maxCount)
				maxCount = me.getValue();
		}
		for(Iterator<Map.Entry<String, Double>> mt = tempTF.iterator();mt.hasNext();){
			Map.Entry<String, Double> me = mt.next();
		//	Double IDF = Math.log(docSum / idfPerWordMap.get(me.getKey()));
		//	wordWeight = (me.getValue() / wordSumPerDoc) * IDF;
			tfPerDocMap.put(me.getKey(), wordWeight);
		}

		TreeMap<String,Double> tempMap = new TreeMap<String, Double>();
		tempMap.putAll(tfPerDocMap);
	//	allDocMap.put(samples[i].getName(), tempMap);


	} */
	
	
}
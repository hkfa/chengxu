package jvlei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Distance {
	public double computeSimilarity(Map<String,Double>map1,Map<String,Double> map2){
		//x1x2+y1y2+z1z2...向量内积 对应词相乘
		Set tem=map1.entrySet();
		Iterator iterator =tem.iterator();
		double mul=0;
		while(iterator.hasNext()){
			Map.Entry<String, Double> me=(Entry<String, Double>) iterator.next();
			if(map2.containsKey(me.getKey())){
				String key=me.getKey();
				mul=mul+map2.get(key)*me.getValue();//testAbs += me.getValue() * me.getValue();
			}//testAbs = Math.sqrt(testAbs);
			/*Set<Map.Entry<String, Double>> trainWordTFMapSet = trainWordTFMap.entrySet();
			for(Iterator<Map.Entry<String, Double>> it = trainWordTFMapSet.iterator(); it.hasNext();){
				Map.Entry<String, Double> me = it.next();
				trainAbs += me.getValue()*me.getValue();
			}
			trainAbs = Math.sqrt(trainAbs);*/

		}
		return mul;/// (testAbs * trainAbs);

	}
	public double getDistance(Map<String,Double> map1,Map<String,Double>map2){
		double distance=1-computeSimilarity(map1,map2);
		return distance;
	}
	public Map<Integer,Map<String,Double>> clusterNearestPoint(Map<Integer,Map<String,Double>>allDocs,Map<Integer,Map<String,Double>>initPoint){
		Map<Integer,Map<String,Double>> classfiy=new HashMap<Integer,Map<String,Double>>();
		double min=2;
		int i=0;
		Set s=allDocs.entrySet();
		Iterator it=s.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Map<String,Double>> me=(Entry<Integer, Map<String, Double>>) it.next();
			Set s2=initPoint.entrySet();
			Iterator it2=s2.iterator();
			while(it2.hasNext()){
				Map.Entry<Integer, Map<String,Double>> me2=(Entry<Integer, Map<String, Double>>) it2.next();
				double dis=getDistance(me.getValue(),me2.getValue());
				if(dis<min){
					min=dis;
					i=me2.getKey();
				}

			}
			classfiy.put(i, me.getValue());
		}
		return classfiy;

	}
}













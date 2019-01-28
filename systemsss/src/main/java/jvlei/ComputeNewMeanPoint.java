package jvlei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class ComputeNewMeanPoint {
	public Map<String,Double> getNewMeanPoint(Map<Integer,Map<String,Double>>allDocs){
		Map<String,Double>temMean=new HashMap<String,Double>();
		Map<String,Double>newMean=new HashMap<String,Double>();
		Set<Map.Entry<Integer,Map<String,Double>>> s=allDocs.entrySet();
		double value=0;
		double value1=0;
		Iterator it=s.iterator();
			while(it.hasNext()){
				Map.Entry<Integer,Map<String,Double>>me=(Map.Entry<Integer, Map<String, Double>>) it.next();
				temMean=me.getValue();
				Set s2=temMean.entrySet();
				Iterator it2=s2.iterator();
				while(it2.hasNext()){
					Map.Entry<String,Double>me2=(Map.Entry<String, Double>) it2.next();
					if(newMean.containsKey(me2.getKey())){
						value1=newMean.get(me2.getKey());
						value=value1+me2.getValue();
						newMean.put(me2.getKey(), value);
					}else{
						newMean.put(me2.getKey(), me2.getValue());
						//map的size大于4了吧。。
					}

				}
				
				
			}
			//在重新输入一遍有问题吗。。
			Set s3=newMean.entrySet();
			Iterator it3=s3.iterator();
			while(it3.hasNext()){
				Map.Entry<String, Double>me3=(Entry<String, Double>) it3.next();
				newMean.put(me3.getKey(), me3.getValue()/s3.size());
			}
			return newMean;
		}
	}



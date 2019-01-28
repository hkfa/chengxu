package jvlei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GetInitPoint {
	public Map<Integer,Map<String,Double>> getInitPoint(Map<String,Map<String,Double>> allDocsTFIDF,int k){
		Map<Integer,Map<String,Double>> initPoint=new HashMap<Integer,Map<String,Double>>();
		Set<Map.Entry<String,Map<String, Double>>> s=allDocsTFIDF.entrySet();
		Iterator <Map.Entry<String,Map<String,Double>>>it=s.iterator();
		int count=0;
		int i=0;
		while(it.hasNext()){
			Map.Entry<String,Map<String,Double>> a= (Entry<String, Map<String, Double>>) it.next();
			if(count==i*(allDocsTFIDF.size()/k)){
				initPoint.put(count, a.getValue());
				i++;
			}
			count++;
		}
		return initPoint;
	}
}

package jvlei;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Transform {
	public void transform(Map<String,Map<String,Double>> allDocs){
		String []allDocNames=new String[allDocs.size()];
		Set s=allDocs.entrySet();
		Iterator it=s.iterator();
		int i=0;
		while(it.hasNext()){
			Map.Entry<String,Map<String,Double>>me=(Entry<String, Map<String, Double>>) it.next();
			allDocNames[i]=me.getKey();
			i++;
		}
	}

}

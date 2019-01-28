package gongjv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[]args){
		int mul=0;
		String []strings={"D","B","C","A","B","D","D","D","B","C"};
		String []stringss={"E","F","G","E","D","D","H"};
		Map<String,Integer> map=new HashMap<String,Integer>();
		Map<String,Integer>map2=new HashMap<String,Integer>();
		Map<String,Map<String,Integer>>map3=new HashMap<String,Map<String,Integer>>();
		List<String> string3=new ArrayList<String>();
		String s1="diyi";
		String s2="dier";
		String s3="disan";
		string3.add(s3);
		string3.add(s2);
		string3.add(s1)
		;
		
		//map.put("A", 1);
		//map.put("B", 2);
		//System.out.println(map.containsKey("A"));
		//System.out.println(map.containsValue(3));
		for(String word:strings){		 
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}else {
				map.put(word, 1);
			}
			Integer wordCount=map.get(word);
			//System.out.println(wordCount);
		}
		for(int i=0;i<string3.size();i++){
		map3.put(string3.get(i), map);
		}
		//TreeMap a=new TreeMap();
		//a.putAll(map);
		
		System.out.println(map3);
		
		
	/*	for(String word:stringss){		 
			if(map2.containsKey(word)) {
				map2.put(word, map2.get(word)+1);
			}else {
				map2.put(word, 1);
			}
			//Integer wordCount=countMap.get(word);
		}
		Set <Map.Entry<String, Integer>> entries=map.entrySet();
		System.out.println(entries);
		
		for(Iterator iterator=entries.iterator();iterator.hasNext();){
			Map.Entry entry=(Entry) iterator.next();
			if(map2.containsKey(entry.getKey())){
				int a=(Integer) entry.getValue();
				int b=map2.get(entry.getKey());
				mul=mul+a*b;
			}
			System.out.println(mul);
			System.out.println(entry);
		}	
		*/
		
		
	
	/*	while(iterator.hasNext()){
			Map.Entry entry=(Entry) iterator.next();
			System.out.println(entry);
			
		}*/
		//System.out.println(iterator);
		


	}
}

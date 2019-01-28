package gongjv;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Suanfa {
	public static void main(String[]args){
		 
		Map<String,Integer>treeMap=new TreeMap<String,Integer>();
		treeMap.put("liming", 1);
		treeMap.put("lihong", 2);
		treeMap.put("lilv", 3);
		treeMap.put("libai", 4);
		treeMap.put("lihei", 5);
		treeMap.put("lida", 6);
		System.out.println(treeMap);
		//treeMap.compute(key, remappingFunction)

	}

}
/*
 * 
 * int a=0;
		while(true){
			System.out.println("haoma");
			if(a==3){
				break;
			}
			a++;
			System.out.println(a);
		}
 * 
 * 
 * 
 *for(int i=0;i<4;i++){
			System.out.println("haoma");
			if(i==2){
				//continue;
				break;
				}
		}
		System.out.println("haode");
 * 
 * 
 * 
 * 
 * Map<Integer,Vector<Integer>>a=new TreeMap<Integer,Vector<Integer>>();
		Vector<Integer> b=new Vector<Integer>();
		Vector<Integer> c=new Vector<Integer>();
		a.put(1, c);
		a.put(0, b);
		
		Integer integer1=new Integer(1);
		Integer integer2=new Integer(2);
		Integer integer3=new Integer(3);
		Integer integer4=new Integer(4);
		String g="fafad";
		b.addElement(integer1);
		b.addElement(integer2);
		//b.addElement(g);
		c.add(0, integer4);
		a.get(0).add(integer1);
		a.get(1).add(integer3);
		System.out.println(c);
		System.out.println(b);
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * int count=0;
 
System.out.println("waimain");
for(int i=0;i<5;){
	if(count==i*5/3){
		System.out.println("lihai");
		i++;
	}
	count++;
	System.out.println("shenmegui");
}
*/
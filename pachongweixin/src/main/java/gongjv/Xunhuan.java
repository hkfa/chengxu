package gongjv;

import java.util.ArrayList;
import java.util.List;

public class Xunhuan {
	public static void main(String[]args){
		//int a=0;
		List<String>contents=new ArrayList<String>();
		String c ="���𷢾�Ŷ���������";
		String b="�뿪��������������";
		String a="Fgdag";
		contents.add(b);
		contents.add(c);
		contents.add(a);
		int count=0;
		for(String content:contents){
		
			System.out.println(count);
			count++;
			System.out.println(content);
		}
	/*	while(a==0){
			a=0;
			System.out.println(a);
			
	
			a=1;
			System.out.println(a);
		}
		System.out.println(a);*/
	}

}

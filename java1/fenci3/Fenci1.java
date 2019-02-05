package fenci3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

public class Fenci1 {


	public static void main(String[] args)throws IOException {

		test();
		System.out.println("123");
	}

	public static void test()throws FileNotFoundException, IOException{
		/*Set<String> expectedNature = new HashSet<String>() {
			{
	            add("n");add("v");add("vd");add("vn");add("vf");
	            add("vx");add("vi");add("vl");add("vg");
	            add("nt");add("nz");add("nw");add("nl");
	            add("ng");add("userDefine");add("wh");
	        }};
	        String words = "�й��������Ĵ������Ź�֮һ�������ƾõ���ʷ�����Լ5000��ǰ������ԭ����Ϊ���Ŀ�ʼ���־�����֯�����ɹ��Һͳ���������������ݱ�ͳ�������������ʱ��ϳ��ĳ������ġ��̡��ܡ����������ơ��Ρ�Ԫ��������ȡ���ԭ������ʷ�ϲ����뱱���������彻������ս���ڶ������ںϳ�Ϊ�л����塣20���ͳ������������й��ľ��������˳���ʷ��̨��ȡ����֮���ǹ������塣1949���л����񹲺͹����������й���½����������������ƶȵ����塣�й����Ŷ�ʵ������Ļ�����ͳ������ʽ��ʫ�ʡ�Ϸ�����鷨�͹����ȣ����ڡ�Ԫ�������������硢������������й���Ҫ�Ĵ�ͳ���ա�";
		 */
		File file=new File("D:\\�½��ļ��� (5)\\123.txt");
		File saveFile=new File("D:\\�½��ļ��� (5)\\456.txt");
		BufferedReader reader=new BufferedReader(new FileReader(file));
		PrintWriter writer =new PrintWriter(saveFile);

		List <Result>tempList=new ArrayList<Result>();
		String string=null;
		StringBuilder strBuilder=new StringBuilder();

		while((string=reader.readLine())!=null){
			Result result=ToAnalysis.parse(string);
			tempList.add(result);
		}
		for(Result r:tempList){
			List<Term> terms =r.getTerms();
			for(int i=0;i<terms.size();i++){
				String word=terms.get(i).getName();
				String natureStr=terms.get(i).getNatureStr();					
				System.out.println(word+natureStr);	
				strBuilder.append(word+natureStr);				
			}			
		}
		writer.print(strBuilder);
		writer.flush();
		writer.close();		
	}


}






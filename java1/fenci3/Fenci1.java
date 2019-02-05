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
	        String words = "中国是世界四大文明古国之一，有着悠久的历史，距今约5000年前，以中原地区为中心开始出现聚落组织进而成国家和朝代，后历经多次演变和朝代更迭，持续时间较长的朝代有夏、商、周、汉、晋、唐、宋、元、明、清等。中原王朝历史上不断与北方游牧民族交往、征战，众多民族融合成为中华民族。20世纪初辛亥革命后，中国的君主政体退出历史舞台，取而代之的是共和政体。1949年中华人民共和国成立后，在中国大陆建立了人民代表大会制度的政体。中国有着多彩的民俗文化，传统艺术形式有诗词、戏曲、书法和国画等，春节、元宵、清明、端午、中秋、重阳等是中国重要的传统节日。";
		 */
		File file=new File("D:\\新建文件夹 (5)\\123.txt");
		File saveFile=new File("D:\\新建文件夹 (5)\\456.txt");
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






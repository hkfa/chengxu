package shili;

import java.util.ArrayList;
import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;



public class jvlei {
	int terms=8;
	int numDoc=4;
	public static void main (String[]args){		
		String title="维基解密否认斯诺登接受委内瑞拉庇护";
		 String content = "歧异方面的处理方式自我感觉还可以，基于最佳实践规则+统计的方式，虽然还有一部分歧异无法识别，但是已经完全能满足工程应用了。至于未登录词的识别，目前重点做了中文人名的识别，效果还算满意，识别方式用的“字体+前后监督”的方式，也算是目前我所知道的效果最好的一种识别方式了。";
		KeyWordComputer kwc=new KeyWordComputer(2);
		List< Keyword> result = kwc.computeArticleTfidf(title);
		List<Double> d=new ArrayList<Double>(result.size());
		for(int i=0;i<result.size();i++){	
		double freq=result.get(i).getFreq();
		double tfidf=result.get(i).getScore();
		d.add(tfidf);
		}
		System.out.print("faf");
		System.out.println(result);
		System.out.println("ga");
	
	}
	
}

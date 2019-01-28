package gongjv;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import mybatis.Mybatis;
import mybatis.Test;

public class Lianxi {
	public static void main(String[]args)throws IOException{
		Mybatis mybatis=new Mybatis();
		List<Test> t=mybatis.getAllDocuments();
		KeyWordComputer k=new KeyWordComputer(3);
		Map<String,Map<String,Double>>allDocMap=new HashMap<String,Map<String,Double>>();
		for(int i=0;i<16;i++){	
			String doc=t.get(i).getTitle();	
			List<Keyword> result=k.computeArticleTfidf(doc);
			Map<String,Double> wordVector=new HashMap<String,Double>();
			for(Keyword word:result){			
				wordVector.put(word.getName(), word.getScore());			
			}
			allDocMap.put(doc, wordVector);
			//System.out.println(wordVector);
		}
		System.out.println(allDocMap);
	
		
	}
}

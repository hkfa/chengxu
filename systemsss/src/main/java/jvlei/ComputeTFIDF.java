package jvlei;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import mybatis.Mybatis;
import mybatis.Test;

public class ComputeTFIDF {
	public Map<String,Map<String,Double>> computeTFIDF ()throws IOException{
		Mybatis mybatis=new Mybatis();
		List<Test> docs=mybatis.getAllDocuments();
		System.out.println(docs.size());
		KeyWordComputer k=new KeyWordComputer(5);				
		int count=0;
		Map<String,Map<String,Double>> allDocsTFIDF=new HashMap<String,Map<String,Double>>();
		for(Test t:docs){
			if(t.getContent()!=null){			
				List<Keyword>docKeyWord=k.computeArticleTfidf(t.getContent());
				
				Map<String,Double>docTFIDF=new HashMap<String,Double>();
				for(int i=0;i<docKeyWord.size();i++){				
					docTFIDF.put(docKeyWord.get(i).getName(), docKeyWord.get(i).getScore());				
				}
				//System.out.println(docTFIDF);				
				if(docTFIDF!=null){
					allDocsTFIDF.put(t.getTitle(), docTFIDF);							
				}				
				count++;
				//System.out.println(count);
			}
			
		}
		//System.out.println(allDocsTFIDF);
		return allDocsTFIDF;
		

	}
}

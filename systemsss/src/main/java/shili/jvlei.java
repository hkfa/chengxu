package shili;

import java.util.ArrayList;
import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;



public class jvlei {
	int terms=8;
	int numDoc=4;
	public static void main (String[]args){		
		String title="ά�����ܷ���˹ŵ�ǽ���ί�������ӻ�";
		 String content = "���췽��Ĵ���ʽ���Ҹо������ԣ��������ʵ������+ͳ�Ƶķ�ʽ����Ȼ����һ���������޷�ʶ�𣬵����Ѿ���ȫ�����㹤��Ӧ���ˡ�����δ��¼�ʵ�ʶ��Ŀǰ�ص���������������ʶ��Ч���������⣬ʶ��ʽ�õġ�����+ǰ��ල���ķ�ʽ��Ҳ����Ŀǰ����֪����Ч����õ�һ��ʶ��ʽ�ˡ�";
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

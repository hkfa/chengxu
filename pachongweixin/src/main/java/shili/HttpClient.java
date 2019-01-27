package shili;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpClient  {
	public static  void main(String []args)throws IOException{
		//Document document1=Jsoup.connect("http://www.xinhuanet.com/").get();
		//Document document2=	Jsoup.connect("http://so.news.cn/#search/0/ÐÛ°²/1//").get();
		//Document document3=Jsoup.connect("http://so.news.cn/getNews?keyword=%E9%9B%84%E5%AE%89&curPage=1&sortField=0&searchFields=1&lang=cn").get();
		Document document3=Jsoup.connect("http://www.he.xinhuanet.com/xinwen/2018-10/20/c_1123587846.htm").get();
		//String a=document1.getElementsByTag("div").toString();
		System.out.println(document3);
		//System.out.println(document1);
		//System.out.println(document2);



	}

}

package weixinde;



import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Ttt implements PageProcessor {
  
	private Site site=Site.me()
			.setSleepTime(3000)
			.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
	public void process (Page page){
		String a=page.getHtml().toString();
		String b=page.getUrl().toString();
		System.out.println(b);
		System.out.println(a);
		
	}
	
	
	
	
	
	
	
	
	
	public Site getSite(){
		return site;
		
	}
	
	
	 public static void main(String []args){
		 System.out.println("gjk");
		Spider.create( new Ttt()).addUrl("http://www.renren.com/").thread(1).run();
		   
	   }
}

	
	

	



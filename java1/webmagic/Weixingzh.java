package weixinde;



import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Weixingzh implements PageProcessor {
	private Site site=  Site.me()
	           .setDomain("sogo.com")
	            .setSleepTime(3000)
	            .setUserAgent
	                ( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");   
	
  public void process(Page page){
	List<String> a= page.getHtml().xpath("[@id=\"edui23\"]/div[@class=\"edui23_state\"]/div[@id=\"edui-button-wrap edui-default\"]/div[@clas\"edui23_body\"]/[class=\"dialog_wrp align_edge link_dialog_wrap ui-draggable\"]/a/@href").all();
	 System.out.print(a);
  }
	public Site getSite (){
		return site;
	}
	

    public static void main(String[] args) {
    
        Spider.create(new tee()).addUrl("https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit_v2&action=edit&isNew=1&type=10&token=1722870418&lang=zh_CN")

                .run();
    }
}

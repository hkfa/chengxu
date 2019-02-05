package weixinde;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class weixinnn implements PageProcessor{
	private Site site=Site.me()
			.setSleepTime(3000);

	public void process(Page page){
		List<String> a=page.getHtml().xpath("//*[@class=\"center\"]/tr/td/text()").all();
		System.out.print(a);

	}
	public Site getSite(){
		return site;
	}

	public static void main(String[]args){
		Spider.create(new weixinnn()).addUrl("https://www.kuaidaili.com/ops/proxylist/2/").run();
	}


}

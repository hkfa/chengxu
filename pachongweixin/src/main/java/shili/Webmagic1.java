package shili;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Webmagic1 implements PageProcessor{
	private Site site=Site.me()

			.setSleepTime(3000)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");


	public void process(Page page) {



		//String title=page.getHtml().xpath("//div[@class='main']//h1//text()").toString();
		//List<String> content=page.getHtml().xpath("//div[@class='main']//div[@class='main-content-box']//p//font//text()").all();
		//	String time=page.getHtml().xpath("//div[@class='timecon']//text()").toString();
		//String origin=page.getHtml().xpath("//div[@class='form']//text()").toString();
		//http://www.xiongan.gov.cn/2018-10/25/c_129979349.htm


		//String title=page.getHtml().xpath("//h1[@id='title']//text()").toString();
		//	List<String> content=page.getHtml().xpath("//div[@class='article']//p//text()").all();
		//	String time=page.getHtml().xpath("//*[@class='time']//text()").toString();
		//String origin=page.getHtml().xpath("//*[@class='sourceText']//text()").toString();
		//  http://www.he.xinhuanet.com/zhuanti/2018-10/25/c_1123608222.htm
		//http://www.he.xinhuanet.com/xinwen/2018-10/23/c_1123598629.htm


		///String title=page.getHtml().xpath("//div[@class='biaoti']//text()").toString();
		//List<String> content=page.getHtml().xpath("//div[@class='zhengwen']//span//p//text()").all();
		//String time=page.getHtml().xpath("//div[@class='laiyuan']//text()").toString();
		//http://www.tj.xinhuanet.com/news/house2016/2018-10/23/c_1123598908.htm

		//String title=page.getHtml().xpath("//div[@class='h-title']//text()").toString();
		//List<String> content=page.getHtml().xpath("div[@id='p-detail']//p//text()").all();
		//String time=page.getHtml().xpath("//[@class='h-time']//text()").toString();
		//String origin=page.getHtml().xpath("//*[@id='source']//text()").toString();
		//http://m.xinhuanet.com/he/2018-10/23/c_1123598629.htm

		///String title=page.getHtml().xpath("//div[@class='h-title']//text()").toString();
		//List<String> content=page.getHtml().xpath("//div[@id='p-detail']//p//text()").all();
		//String time=page.getHtml().xpath("//*[@class='h-time']//text()").toString();
		//String origin=page.getHtml().xpath("//*[@id='source']//text()").toString();
		//http://www.xinhuanet.com/2018-10/18/c_1123575632.htm

		//String title=page.getHtml().xpath("//div[@class='top_tit']//text()").toString();
		//List<String> content=page.getHtml().xpath("//div[@class='mainCon']//p//text()").all();
		//String time=page.getHtml().xpath("//*[@class='sj_scro']//span//text()").toString();
		//String origin=page.getHtml().getDocument().getElementsByClass("sj_scro").get(0).getElementsByTag("span").get(2).text().toString();
		//http://jjckb.xinhuanet.com/2018-10/18/c_137540752.htm

		//String title=page.getHtml().xpath("//div[@id='Title']//text()").toString();
		//List<String> content=page.getHtml().xpath("//tbody//tr//td//@[@id='Content']//p//text()").all();
		//String time=page.getHtml().xpath("//*[@class='gray fs12']//text()").toString();
		//String origin=page.getHtml().xpath("//*[@class='gray fs12']//font//text()").toString();
		//http://www.xinhuanet.com//mrdx/2018-10/18/c_137540854.htm
		//不行。。有待改进

		/*for(int i=2;i<4;i++){
		   String pageUrl="http://so.news.cn/getNews?keyword=%E9%9B%84%E5%AE%89&curPage="+i+"&sortField=0&searchFields=1&lang=cn";
			  page.addTargetRequest(pageUrl);
				}
		List<String> a=page.getHtml().regex("http://[\\w+\\.?/?]+\\w+-\\d+/\\d+/\\w+\\.htm").all();

		String title=page.getHtml().xpath("//div[@class='main']//h1//text()").toString();
		List<String> content=page.getHtml().xpath("div[@class='main']//div[@class='main-content-box']//p//font//text()").all();

*/
String a=page.getUrl().toString();
		System.out.println(a);
		
		//System.out.println(time);
		//System.out.println(origin);
	
	}
	

	public Site getSite() {

		return site;
	}




	public static void main(String[]args){
		Spider.create(new Webmagic1()).addUrl("http://www.xinhuanet.com/2018-10/18/c_1123575632.htm").run();

	}




}


package shili;

import java.util.List;

import mybatis.Model;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class Webmagic implements PageProcessor{

	private static final String listUrl="http://\\w+\\.\\w+\\.\\w+/\\w+\\?\\w+\\=%\\w+\\%\\w+\\%\\w+\\%\\w+\\%\\w+\\%\\w+\\&\\w+\\=\\d+\\&\\w+\\=\\d+\\&\\w+\\=\\d+\\&\\w+\\=\\w+";//有待改进
	
	String title;
	String origin;
	String time;
	List<String> content;
	String url;
	private Site site =Site.me()
			.setTimeOut(30000)
			.setSleepTime(3000)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");




	public void process(Page page) {
		if(page.getUrl().regex(listUrl).match()){
			for(int i=2;i<716;i++){
				String pageUrl="http://so.news.cn/getNews?keyword=%E9%9B%84%E5%AE%89&curPage="+i+"&sortField=0&searchFields=1&lang=cn";
				page.addTargetRequest(pageUrl);
			}
			List<String> links=page.getHtml().regex("http://[\\w+\\.?/?]+\\w+-\\d+/\\d+/\\w+\\.htm").all();
			//System.out.println(links);
			page.addTargetRequests(links);

		}
		else{	
			String text=null;
			if(text==null){		
				url=page.getUrl().toString();
				title=page.getHtml().xpath("//div[@class='main']//h1//text()").toString();
				content=page.getHtml().xpath("//div[@class='main']//div[@class='main-content-box']//p//font//text()").all(); 
				time= page.getHtml().xpath("//div[@class='timecon']//text()").toString();
				origin= page.getHtml().xpath("//div[@class='form']//text()").toString();
				
				text=title;
				if(text==null){	
					url=page.getUrl().toString();
					String title=page.getHtml().xpath("//h1[@id='title']//text()").toString();
					List<String> content=page.getHtml().xpath("//div[@class='article']//p//text()").all();
					String time=page.getHtml().xpath("//*[@class='time']//text()").toString();
					String origin=page.getHtml().xpath("//*[@class='sourceText']//text()").toString();
					text=title;
					if(text==null){ 
						url=page.getUrl().toString();
						title=page.getHtml().xpath("//div[@class='h-title']//text()").toString();
						content=page.getHtml().xpath("//div[@id='p-detail']//p//text()").all();
						time=page.getHtml().xpath("//*[@class='h-time']//text()").toString();
						origin=page.getHtml().xpath("//*[@id='source']//text()").toString();
						text=title;
						if(text==null){
							url=page.getUrl().toString();
							title=page.getHtml().xpath("//div[@class='h-title']//text()").toString();
							content=page.getHtml().xpath("div[@id='p-detail']//p//text()").all();
							time=page.getHtml().xpath("//[@class='h-time']//text()").toString();
							origin=page.getHtml().xpath("//*[@id='source']//text()").toString();
							text=title;
							if(text==null){
								url=page.getUrl().toString();
								title=page.getHtml().xpath("//div[@class='biaoti']//text()").toString();
								content=page.getHtml().xpath("//div[@class='zhengwen']//span//p//text()").all();
								time=page.getHtml().xpath("//div[@class='laiyuan']//text()").toString();
								origin=time;
								text=title;
								if(text==null) {
									url=page.getUrl().toString();
									title=page.getHtml().xpath("//div[@class='top_tit']//text()").toString();
									content=page.getHtml().xpath("//div[@class='mainCon']//p//text()").all();
									time=page.getHtml().xpath("//*[@class='sj_scro']//span//text()").toString();
									origin=page.getHtml().getDocument().getElementsByClass("sj_scro").get(0).getElementsByTag("span").get(2).text().toString();
								}
								else{set(page,title,content,origin,time,url);}
							}else{set(page,title,content,origin,time,url);}
						}else{set(page,title,content,origin,time,url);}
					}else{set(page,title,content,origin,time,url);}
				}else{
					set(page,title,content,origin,time,url);
				}
			}
			


		}



	}



	public void set(Page page,String title,List<String> content,String origin,String time,String url){
		Model model=new Model();
		for(String s:content)
		{model.setContent(s);}
		model.setOrigin(origin);
		model.setTime(time);
		model.setTitle(title);
		model.setUrl(url);
		page.putField("xinhua", model);
	}


	public Site getSite() {

		return site;
	}

	public static void main(String[]args){

		Spider.create(new Webmagic())
		.addUrl("http://so.news.cn/getNews?keyword=%E9%9B%84%E5%AE%89&curPage=1&sortField=0&searchFields=1&lang=cn").addPipeline(new MyPipeline()).run();

	}


}


//有待改进。MINAServer Logger--> INFO{Spider.java:338}-Spider so.news.cn closed! 6733 pages downloaded.  不是7150
/*一
 *  *MINAServer Logger-->ERROR{Spider.java:324}-process request Request{url='http://uav.xinhuanet.com/2017-04/01/c_1120741576.htm', method='null', extras=null, priority=0, headers={}, cookies={}} error 
java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:653)
	at java.util.ArrayList.get(ArrayList.java:429)
	at shili.Webmagic.process(Webmagic.java:84)
	at us.codecraft.webmagic.Spider.onDownloadSuccess(Spider.java:414)
	at us.codecraft.webmagic.Spider.processRequest(Spider.java:406)
	at us.codecraft.webmagic.Spider.access$000(Spider.java:61)
	at us.codecraft.webmagic.Spider$1.run(Spider.java:320)
	at us.codecraft.webmagic.thread.CountableThreadPool$1.run(CountableThreadPool.java:74)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

*二
*MINAServer Logger--> WARN{HttpClientDownloader.java:91}-download page http://news.xiongan.gov.cn/2017-04/05/c_1120752819.htm error
java.net.UnknownHostException: news.xiongan.gov.cn
	at java.net.Inet6AddressImpl.lookupAllHostAddr(Native Method)
	at java.net.InetAddress$2.lookupAllHostAddr(InetAddress.java:928)
	at java.net.InetAddress.getAddressesFromNameService(InetAddress.java:1323)
	at java.net.InetAddress.getAllByName0(InetAddress.java:1276)
	at java.net.InetAddress.getAllByName(InetAddress.java:1192)
	at java.net.InetAddress.getAllByName(InetAddress.java:1126)
	at org.apache.http.impl.conn.SystemDefaultDnsResolver.resolve(SystemDefaultDnsResolver.java:45)
	at org.apache.http.impl.conn.DefaultHttpClientConnectionOperator.connect(DefaultHttpClientConnectionOperator.java:111)
	at org.apache.http.impl.conn.PoolingHttpClientConnectionManager.connect(PoolingHttpClientConnectionManager.java:353)
	at org.apache.http.impl.execchain.MainClientExec.establishRoute(MainClientExec.java:380)
	at org.apache.http.impl.execchain.MainClientExec.execute(MainClientExec.java:236)
	at org.apache.http.impl.execchain.ProtocolExec.execute(ProtocolExec.java:184)
	at org.apache.http.impl.execchain.RetryExec.execute(RetryExec.java:88)
	at org.apache.http.impl.execchain.RedirectExec.execute(RedirectExec.java:110)
	at org.apache.http.impl.client.InternalHttpClient.doExecute(InternalHttpClient.java:184)
	at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:82)
	at us.codecraft.webmagic.downloader.HttpClientDownloader.download(HttpClientDownloader.java:85)
	at us.codecraft.webmagic.Spider.processRequest(Spider.java:404)
	at us.codecraft.webmagic.Spider.access$000(Spider.java:61)
	at us.codecraft.webmagic.Spider$1.run(Spider.java:320)
	at us.codecraft.webmagic.thread.CountableThreadPool$1.run(CountableThreadPool.java:74)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
*
*
*/


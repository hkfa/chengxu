package com.springboot.webmagic;



import java.util.List;


import com.springboot.model.Xinlang;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;


import us.codecraft.webmagic.processor.PageProcessor;



public class PageProcessors implements PageProcessor{

	private Site site =Site.me()
			.setDomain("blog.sina.com.cn")
			.setSleepTime(3000)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");


	public Site getSite() {
		return site;
	}
	public static final String URL_LIST = "http://blog\\.sina\\.com\\.cn/s/articlelist_1487828712_0_\\d+\\.html";
	public static final String URL_POST = "http://blog\\.sina\\.com\\.cn/s/blog_\\w+\\.html";

	public void process(Page page) {
		if (page.getUrl().regex(URL_LIST).match()) {
			List<String> b=page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex(URL_POST).all();
			for(String r:b){
				page.addTargetRequest(r);
				}
			}else{
			String title=page.getHtml().xpath("//div[@class='articalTitle']/h2/text()").toString();
			set(title,page);
			}
		}
		//page.putField("url",page.getUrl().regex("https://blog\\.csdn\\.net/.*/article/details/[0-9]{8}"));
		//page.addTargetRequests(page.getHtml().links().regex("https://blog\\.csdn\\.net/.*/article/details/[0-9]{8}").all());
		//String title=page.getHtml().xpath("//div[@class=\"container clearfix\"]/main/div/div/div/div//h1/text()").toString();
		//	String time= page.getHtml().xpath("//div[@class=\"article-info-box\"]/div//span[@class=\"time\"]/text()").toString();
		//String readcount= page.getHtml().xpath("//div[@class=\"float-right\"]//span/text()").toString();
		// page.putField("content",page.getHtml().css("#mainBox > main > div.blog-content-box > article"));

		//String htmlContent =page.getHtml().css("#mainBox > main > div.blog-content-box > article").get();
		//page.putField("content",Jsoup.parse(String.valueOf(htmlContent)).text());
		//set(title,time,readcount,page);


	
	private void set(String title,Page page){
		Xinlang xinlang=new Xinlang();
		//model.setReadcount(readcount);
	//	model.setTime(time);
		//model.setTitle(title);
		xinlang.setTitle(title);
		page.putField("xinlang", xinlang);


	}



}

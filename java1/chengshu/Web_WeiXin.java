package weixinde;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

	/**

	 */
	public class tee  implements PageProcessor {
		  public static final String URL_LIST = "http://weixin\\.sogou\\.com/\\w+";
		  public static final String URL="http://weixin.sogou.com/weixin?oq=&query=科技&_sug_type_=1&sut=0&lkt=0%2C0%2C0&s_from=input&ri=2&_sug_=n&type=2&sst0=1532566624648&page=3&ie=utf8&p=40040108&dp=1&w=01015002&dr=1";
	  
	    private Site site = Site
	            .me()
	           .setDomain("sogo.com")
	            .setSleepTime(3000)
	            .addCookie("Cookie", "SUV=004F914C651739C158E193435C247073; ssuid=7507317260; pgv_pvi=8614441984; dt_ssuid=625364110; _ga=GA1.2.356553379.1492075813; pex=C864C03270DED3DD8A06887A372DA219231FFAC25A9D64AE09E82AED12E416AC; m=678BE95EF107BC70C67AEF3DA48317B4; CXID=AB80ECFB3EB8C32E73D11AB8D0122107; OPENID=16274A87379BFC3367E41A8523BD831C; "
	            		+ "sw_uuid=7860801776; sg_uuid=5883635411;"
	            		+ " tv_play_records=tvshow_2276217:20180629$%B1%BC%C5%DC%B0%C9:20170609; "
	            		+ "teleplay_play_records=teleplay_2953:1$%B1%B1%BE%A9%C7%E0%C4%EA:32$%CE%E4%C1%D6%CD%E2%B4%AB:8$%BB%B9%D6%E9%B8%F1%B8%F1%B5%DA%D2%BB%B2%BF:1; cd=1531455808&116c293c4730b96ca50f2c24da1e4f04; ABTEST=8|1531458212|v1; "
	            		+ "weixinIndexVisited=1; IPLOC=CN1301; ad=XZllllllll2zOvMelllllVHF3OYlllllTta0qlllllwlllllVylll5@@@@@@@@@@; SUID=12B3C0DD2208990A0000000058E332F1;"
	            		+ " YYID=678BE95EF107BC70C67AEF3DA48317B4; SNUID=45DDA7C5BBBECD718B2C8ABDBC57D3D8; clientId=0D7851DAD1C36E4A00BA5DFCD00B6F8D;"
	            		+ " JSESSIONID=aaa0s2DKfQwteh8fYuHsw; pgv_si=s5500028928; "
	            		+ "usid=NawB861f6coCX0Oj; sct=1549; "
	            		+ "ld=gyllllllll2z$OZcQ1kIyVHBP32bvjOlbsXLhlllljwlllllpklll5@@@@@@@@@@; LSTMV=240%2C75; LCLKINT=2705; ppinf=5|1532593414|1533803014|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MjAxN3x1bmlxbmFtZToxODolRTklODAlQkUlRTYlOUMlOUZ8Y3J0OjEwOjE1MzI1OTM0MTR8cmVmbmljazoxODolRTklODAlQkUlRTYlOUMlOUZ8dXNlcmlkOjQ0Om85dDJsdUFHWHVJcy1mcVVoZ1l3R2VXVzN2eEFAd2VpeGluLnNvaHUuY29tfA; pprdig=qEm4gjuqmsVJeq8xOVQtnhGpeGjo0Q7C0Ph1L3rTsZB_4Isko4QDpOS2nsIvb-v0mrIIj1VEbJcf2hP9hmp6aBhxsX-rpAawkgEeVW94ofr83hzg1Bow3zLoUuPyP-f_MTIclxrc1I1r6uWbysKTh_AqfSB4-JtqIZGZZbeWGug; sgid=30-36266519-AVtZhQYlGFw2tC8pwGFNJNU")
	            .setUserAgent(
	                 "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");


	    public void process(Page page) {
	   //  List<String> rulList=new ArrayList<String>();
	    //	for(int i=0;i<10;i++){
	    	//	rulList.add("");
	    		
	    	
	    	
	    	
	    	
	       if (page.getUrl().regex(URL_LIST).match()) {
	  List    <String> lists=	page.getHtml().xpath("//*[@class=\"txt-box\"]/h3/a/@href").all();
	  
	  page.addTargetRequests(lists);
	  
	   List   <String> rulist=page.getHtml().xpath("//*[@class=\"p-fy\"]/a/@href").all();
   for(String s:rulist){
	 String ee= s.replace("?", "http://weixin.sogou.com/weixin?");
	 page.addTargetRequest(ee);
	 
   }
	       }	
	      
		         
	        else { 
	        	
      
          String a =    page.getHtml().xpath("//div[@id=\"img-content\"]/h2/text()").toString();
        List<  String> b=page.getHtml().xpath("//div[@class=\"img-content\"]/div[@class=\"rich_media_content\"]/p").all();
        
         
          System.out.print(b);
	   	 
	   	         
	        }
	        
	    }


	    public Site getSite() {
	        return site;
	    }

	    public static void main(String[] args) {
	    
	        Spider.create(new tee()).addUrl("http://weixin.sogou.com/weixin?type=2&query=科技&ie=utf8&s_from=input&_sug_=n&_sug_type_=1&w=01015002&oq=&ri=2&sourceid=sugg&sut=0&sst0=1532566624648&lkt=0%2C0%2C0&p=40040108")
	                .run();
	    }
	}
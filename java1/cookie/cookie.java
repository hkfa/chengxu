package jinajie;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import weixinde.weixinnn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



	
		    /*    CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
		        HttpPost httpPost = new HttpPost("https://www.zhihu.com/api/v3/oauth/sign_in") ;
		        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		        nvps.add(new BasicNameValuePair("_xsrf", "GjfTKOFtL5EdzHYjFzcKR4D7loETiqO6"));
		        nvps.add(new BasicNameValuePair("password", "1325200471"));
		        nvps.add(new BasicNameValuePair("captcha_type", "cn"));
		        nvps.add(new BasicNameValuePair("phone_num", "15890956765"));

		        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost) ;
		        HttpEntity entity = closeableHttpResponse.getEntity() ;
		        String s = EntityUtils.toString(entity);
		        System.out.println(s);
		    }
		}
*/public class tee implements PageProcessor{
	private Site site=Site.me()
			.setSleepTime(3000)
		
			.addCookie("_xsrf", "GjfTKOFtL5EdzHYjFzcKR4D7loETiqO6 " )
			.addCookie("phone_num", "15890956765")
			.addCookie("password", "1325200471")
			.addCookie("captcha_type"," cn")
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
			
			




	
	
	public void process(Page page){
		String a=page.getHtml().toString();
		System.out.print(a);

	}
	
	
	
	
	
	
	
	
	
	public Site getSite(){
		return site;
	}

	public static void main(String[]args){
		Spider.create(new weixinnn()).addUrl("https://www.zhihu.com/").run();
	}
	}

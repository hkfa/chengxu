package weixinde;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.assertj.core.internal.Lists;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.apache.http.client.CookieStore;

public class Cookie {
	public static void main(String [] args) throws URISyntaxException , ClientProtocolException,IOException, ClassNotFoundException {
		 String url = "https://www.zhihu.com/";
		 List<NameValuePair> loginNV=new ArrayList<NameValuePair>();
		 loginNV.add(new BasicNameValuePair("name","test"));
		 loginNV.add(new BasicNameValuePair ("password","test"));
		 URI uri=new URIBuilder(url).setParameters(loginNV).build();
		 
		 HttpUriRequest request=RequestBuilder.get().setUri(uri).build();
		
		 List<Header> headerList = new ArrayList<Header>();
		    headerList.add(new BasicHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9," +
		            "image/webp,image/apng,*/*;q=0.8"));
		    headerList.add(new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
		            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"));
		    headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"));
		    headerList.add(new BasicHeader(HttpHeaders.CACHE_CONTROL, "max-age=0"));
		    headerList.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));
		    headerList.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4,ja;q=0.2," +
		            "de;q=0.2"));
		HttpClient httpclient =HttpClients.custom().setDefaultHeaders(headerList).build();
		HttpClientContext context=HttpClientContext.create();
	  httpclient.execute(request,context);
	  CookieStore cookiestore=context.getCookieStore();
	  System.out.println(cookiestore);
	  saveCookieStore (cookiestore,"cookie");
	  
	  CookieStore	cookiestore1=readCookieStore("cookie");
	  System.out.print(cookiestore1);
	  
/*	HttpClient httpclient1= HttpClientBuilder.create().setDefaultCookieStore(cookiestore1).build();

	   
	  
      HttpResponse response=   context.getResponse();
String responsestr=EntityUtils.toString( response.getEntity(),"utf8");
      System.out.println( responsestr);
      Jsoup.parse(responsestr);
     */
      
      
		
	}
	
	
  private static void  saveCookieStore (CookieStore cookieStore,String savePath ) throws IOException{
	   FileOutputStream fs = new FileOutputStream(savePath);
	    ObjectOutputStream os =  new ObjectOutputStream(fs);
	   os.writeObject(cookieStore);
	    os.close();

	   
   }
	private static CookieStore readCookieStore (String savePath)throws IOException, ClassNotFoundException{
		 FileInputStream fs = new FileInputStream("cookie");//("foo.ser");
		    ObjectInputStream ois = new ObjectInputStream(fs);
		    CookieStore cookieStore = (CookieStore) ois.readObject();
		    ois.close();
		    return cookieStore;

	}
	
}

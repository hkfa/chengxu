package weixinde;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class FAfa {
	//static String  It;		
	//static String execution;
	//static String _eventId;
	static String  account="";
	static String password="";		
	static String ab;
	public static void main(String[]args)  throws UnsupportedEncodingException, ClientProtocolException,IOException{
		CloseableHttpClient client=HttpClientBuilder.create().build();
	 HttpResponse response=null;
		HttpPost post=new HttpPost("http://www.zuidaima.com/user/login.htm");
	
		
	//	BasicHeader x=new BasicHeader ("cookie","zdmid=2782A4342F7900B0406A63A47C00FE43");
		//post.addHeader(x);
		post.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		post.addHeader("Origin", "http://www.zuidaima.com");
		post.addHeader("Referer", "http://www.zuidaima.com/user/login.htm");
		
		
		List<NameValuePair>nvps=new ArrayList<NameValuePair>();
		BasicNameValuePair a=new BasicNameValuePair("account","1152547530@qq.com");
		BasicNameValuePair b=new BasicNameValuePair("password","NARUTO666");
		UrlEncodedFormEntity uefEntity=new UrlEncodedFormEntity(nvps,"UTF-8");
		post.setEntity(uefEntity);
		
		response=client.execute(post);
		 HttpEntity entity=response.getEntity();
		 InputStream in=entity.getContent();
		 System.out.println(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println(br);
		String line="";
		String result="";
		while((line=br.readLine())!=null){
			result+=line;
			System.out.println(result);
		}
    
		Document document=Jsoup.parse(result);
		//System.out.println(document);
	}
	
		
	}	





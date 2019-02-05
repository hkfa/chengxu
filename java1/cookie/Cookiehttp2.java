package jinajie;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;


public class Cookiehttp2 {
	public static void main(String[]args)throws UnsupportedEncodingException{
	
	CloseableHttpClient client= HttpClientBuilder.create().build();
	

	String url="https://home.autonews.com/clickshare/cspLogin.do";
	HttpPost httppost=new HttpPost(url);
	List<NameValuePair>nvps=new ArrayList<NameValuePair>();
	nvps.add(new BasicNameValuePair("CSDropAuthCookieSpecified","1"));
	nvps.add(new BasicNameValuePair("CSParamsToPassNames","CSParamsToPassNames"));
	nvps.add(new BasicNameValuePair("userLogin.userName","1152547530@qq.com"));
	nvps.add(new BasicNameValuePair("1152547530@qq.com","123"));
	nvps.add(new BasicNameValuePair("submit","Sign In"));
	 UrlEncodedFormEntity encoded=new UrlEncodedFormEntity (nvps,"UTF-8");
	 httppost.setEntity(encoded);
	
	
	
	
	
	
}
}

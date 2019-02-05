package jinajie;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.AbstractDownloader;
import us.codecraft.webmagic.downloader.HttpClientGenerator;
import us.codecraft.webmagic.Request;
public class Cookiee {
	public String cookie;
	public String showMoreURL;
	//public String session_token;request header
	/*public String client_url;
	public  void VideoSpider(String url,String proxySty){
	/*	String[] tmp=proxySty.split(";");
		Site site = Site.me().setRetryTimes(3).setHttpProxy(proxy).setSleepTime(100).setTimeOut(10 * 1000).setCharset("UTF-8")
				.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");		
	//	GPHttpclientDownloader downloader=new GPHttpClientDownloader();
		Request request = new Request("");
		this.setCookie(request, site, downloader);
	}
	public void setCookie (Request request,Site site ,GPHttpClientDownloader downloader){
		CloseableHttpResponse httpResponse=downloader.downloaderForResponse(request,site.toTask());
		
		
	}
*/






	public static void main(String []args){		
		System.out.print( "a");
	}
}

class GPHttpClientDownloader extends AbstractDownloader {
	private HttpClientGenerator httpClientGenerator=new HttpClientGenerator();
	 final Map<String, CloseableHttpClient> httpClients = new HashMap<String, CloseableHttpClient>();
	public Page download(Request arg0, Task arg1) {
		return null;
	}
	 private CloseableHttpClient getHttpClient(Site site) {
	        if (site == null) {
	            return httpClientGenerator.getClient(null);
	        }
	        String domain = site.getDomain();
	        CloseableHttpClient httpClient = httpClients.get(domain);
	        if (httpClient == null) {
	            synchronized (this) {
	                httpClient = httpClients.get(domain);
	                if (httpClient == null) {
	                    httpClient = httpClientGenerator.getClient(site);
	                    httpClients.put(domain, httpClient);
	                }
	            }
	        }
	        return httpClient;
	 }
	// public Page downloader(){return }
	 //public CloseableHttpResponse downloaForReponse(){
		 
	 //}
	 //public Request 
	   
	public void setThread(int arg0) {
	
		
	}
}



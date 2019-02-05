package weixinde;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpJsoup {
	public static void main(String []args){
		System.out.print("KH");
		CloseableHttpClient httpClient = HttpClients.createDefault();
	}
}
	//	Registry<CookieSpecProvider> cookieSpecProviderRegistry = RegistryBuilder.<CookieSpecProvider>create()
              //  .register("myCookieSpec", context -> new MyCookieSpec()).build();//×¢²á×Ô¶¨ÒåCookieSpec
		//String url = baseUrl + i;
		//HttpGet get = new HttpGet(url);
		//HttpClientContext context = HttpClientContext.create();
	//	 context.setCookieSpecRegistry(cookieSpecProviderRegistry);
		// get.setConfig(RequestConfig.custom().setCookieSpec("myCookieSpec").build());
	//	 WebRequest request = null;
	// WebClient wc = null;
		//try {
			
	/*		CloseableHttpResponse response = httpClient.execute(get, context);
	
			System.out.println("status:" + response.getStatusLine());
			System.out.println(">>>>>>headers:");
			HeaderIterator iterator = response.headerIterator();
			while (iterator.hasNext()) {
				System.out.println("\t" + iterator.next());
			}
			System.out.println(">>>>>>cookies:");
			// context.getCookieStore().getCookies().forEach(System.out::println);
			String cookie =getCookie(context);
			System.out.println("cookie="+cookie);

		System.out.print(a);
		response.close();
	}
}}
*/
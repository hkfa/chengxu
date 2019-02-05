package jinajie;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * @author:合肥工业大学 管理学院 钱洋
 * @email:1563178220@qq.com
 * @ 
 */
public class Cookietabel {

	public static void main(String[] args) throws Exception {
		DefaultHttpClient client = new DefaultHttpClient();  
		String newUrl = "https://las.cnas.org.cn/LAS/publish/queryPublishKeyBranch.action?";      
		HttpPost post = new HttpPost(newUrl);  
		System.out.println(post);

		post.addHeader(new BasicHeader("Cookie",  
				"JSESSIONID=0000XpO3I17IbY_to2AkHvR5DO_:1a5s8urra0"));  
		post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");  
		post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");  
		post.addHeader("Host", "las.cnas.org.cn");  
		post.addHeader("Accept", "*/*");  
		post.addHeader("Accept-Language", "zh-CN,zh;q=0.8");  
		post.addHeader("X-Requested-With", "XMLHttpRequest");
		post.addHeader("Referer", "https://las.cnas.org.cn/LAS/publish/lab/keyBranchListView.jsp?baseInfoId=3ee5aa672cbf44d0a2d9906b2bae70c5");
		post.addHeader("Origin", "https://las.cnas.org.cn");   

		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("asstId", "3ee5aa672cbf44d0a2d9906b2bae70c5"));
		post.setEntity(new UrlEncodedFormEntity(list));
		System.out.println(post);
		org.apache.http.HttpResponse httpResponse = client.execute(post);  
		String responseString = EntityUtils.toString(httpResponse.getEntity());  
		System.out.println(responseString);

	}
}

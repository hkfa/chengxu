package weixinde;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;



public class Sql implements PageProcessor {

	public static final String URL_LIST = "http://blog\\.sina\\.com\\.cn/s/articlelist_1487828712_0_\\d+\\.html";
	public static final String URL_POST = "http://blog\\.sina\\.com\\.cn/s/blog_\\w+\\.html";
	private Site site = Site
			.me()
			.setDomain("blog.sina.com.cn")
			.setSleepTime(3000)
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");


	public void process(Page page) {
		//列表页
		Dao test=new Dao ();
		if (page.getUrl().regex(URL_LIST).match()) {
			List<String> b=page.getHtml().xpath("//div[@class=\"articleList\"]").links().regex(URL_POST).all();
			for(String r:b){
				test.setlink(r);
				page.addTargetRequest(r);
			}
			
			//   page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
			

		} else {

			String a =page.getHtml().xpath("//div[@class='articalTitle']/h2/text()").toString();
		
			test.settitle(a);

			Connection connection=null;
			String driver="com.mysql.jdbc.Driver";   
			String dbURL="jdbc:mysql://127.0.0.1:3306/free?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
			String user = "root";
			String password = "666";
			try{	Class.forName(driver);  }catch( ClassNotFoundException e){e.printStackTrace();}
			try {
				connection = DriverManager.getConnection(dbURL,user,password);
				if(!connection.isClosed()){
					System.out.println("sucess");			}

				String sql=""
						+ "insert into test"
						+ "(title,link)"
						+ "values(?,?)";//我们使用占位符
				PreparedStatement state = connection.prepareStatement(sql);
				System.out.println(test.gettitle());
				state.setString(1,test.gettitle() );
				state.setString(2,test.getlink());

				state.execute();
				System.out.print(state);


			} catch (SQLException e) {
				e.printStackTrace();
			}     
		}
	}
	//System.out.print(test.gettitle());


	//  page.putField("content", page.getHtml().xpath("//div[@id='articlebody']//div[@class='articalContent']"));
	//page.putField("date",
	//      page.getHtml().xpath("//div[@id='articlebody']//span[@class='time SG_txtc']").regex("\\((.*)\\)"));




	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new Sql()).addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html")
		.run();
	}

}		
class Dao {

	private  String title;
	private  String link;
	public   void settitle(String title){
		this.title=title;

	}
	public void setlink(String link){
		this.link=link;
	}
	public String gettitle(){

		return title;
	}	
	public String getlink(){
		return link;
	}

}

package gongjv;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhengze {
	public static void main(String[]args){
		//http://[\\w+\\.?/?]+\\w+
		//"http://[\\w+\\.?/?]+\\.[A-Za-z]+"
       //Pattern p=Pattern.compile("http://[\\w+\\.?/?]+\\w+-\\d+/\\d+/\\w+\\.htm");
		//private static final String pageUrl1="http://\\w+\\.xiongan.gov.cn/\\w+-\\d+/\\d+/\\w+\\.htm";
		//String allStrings="url,http://www.xiongan.gov.cn/2018-10/20/c_129975986.htm";
		//Pattern p=Pattern.compile("http://\\w+\\.\\w+\\.\\w+/\\w+\\?\\w+\\=%\\w+\\%\\w+\\%\\w+\\%\\w+\\%\\w+\\%\\w+\\&\\w+\\=\\d+\\&\\w+\\=\\d+\\&\\w+\\=\\d+\\&\\w+\\=\\w+");
		//String allStrings="http://so.news.cn/getNews?keyword=%E9%9B%84%E5%AE%89&curPage=1&sortField=0&searchFields=1&lang=cn";
		
		//Pattern p=Pattern.compile("http://\\www.xiongan.gov.cn/\\w+-\\d+/\\d+/\\w+\\.htm");
		//String allStrings="http://www.xiongan.gov.cn/2018-10/25/c_129979349.htm";
			
		//Pattern p=Pattern.compile("http://\\www.he.xinhuanet.com/zhuanti/\\d+-\\d+/\\d+/\\w+.htm");
		
		
		
		//Pattern p=Pattern.compile("http://\\www.he.xinhuanet.com/\\w+/\\d+-\\d+/\\d+/\\w+.htm");
		//String allStrings=" http://www.he.xinhuanet.com/xinwen/2018-10/23/c_1123598629.htm";
		//String allStrings=" http://www.he.xinhuanet.com/zhuanti/2018-10/25/c_1123608222.htm";
		
		//Pattern p=Pattern.compile("http://\\www.tj.xinhuanet.com/\\w+/\\w+/\\d+-\\d+/\\d+/\\w+.htm");
		//String allStrings=" http://www.tj.xinhuanet.com/news/house2016/2018-10/23/c_1123598908.htm";
		
		//Pattern p=Pattern.compile("http://\\w+\\.xinhuanet.com/\\w+/\\d+-\\d+/\\d+/\\w+.htm");
		//String allStrings="http://m.xinhuanet.com/he/2018-10/23/c_1123598629.htm";
				
		//Pattern p=Pattern.compile("http://\\w+\\.xinhuanet.com/\\d+-\\d+/\\d+/\\w+.htm");
		//String allStrings="http://www.xinhuanet.com/2018-10/18/c_1123575632.htm";
		
		Pattern p=Pattern.compile("http://\\w+\\.xinhuanet.com/\\d+-\\d+/\\d+/\\w+.htm");
		String allStrings="http://jjckb.xinhuanet.com/2018-10/18/c_137540752.htm";
		
		List<String> result=new ArrayList<String>();
			Matcher matcher=p.matcher(allStrings);
			while(matcher.find()){
			
			//boolean result=matcher.matches();
				String result1=matcher.group();
			result.add(result1);
			
		}
			System.out.println("原字符"+allStrings);
			System.out.println("匹配字符"+result);
	}

}
/*<html>
 <head></head>
 <body>
  {"code":200,"content":{"recommendation":null,"keyword":"雄安","sortField":"0","optionsSearchTypes":null,"curPage":2,"results":[{"code":null,"contentId":"849706900ac54f2d96a3e219cba34cd4","des":"河北省政府办公厅近日印发《关于加强省会开放引领的实施意见》明确，要抓住国家规划建设雄安新区的机遇，积极推进省会与雄安新区协同发展，与雄安新区共同申报国家级开放创新试点，在探索开放型经济运行管理新模式、国际投资合作新方式、建立质量效益型外贸新体系等方面取得突破，共同打造内陆开放创新高地。","imgUrl":null,"keyword":"雄安新区;创新试点;自贸试验区","listResult":null,"pubtime":"2018-10-20 11:09:09","sitename":"雄安中文官网","title":"河北积极推进石家庄与
  <font color="red">雄安</font>新区共同申报国家级开放创新试点","url":"http://www.xiongan.gov.cn/2018-10/20/c_129975986.htm"},{"code":null,"contentId":"084628ec032d4ecc8a7bb1f0ece805f3","des":"探访第一届河北国际工业设计周，今天带您走进国际先锋设计科技体验馆。","imgUrl":null,"keyword":"河北;工业;设计周;探访","listResult":null,"pubtime":"2018-10-20 11:02:20","sitename":"雄安中文官网","title":"工业设计周鲜体验：
  <font color="red">雄安</font>“观音”","url":"http://www.xiongan.gov.cn/2018-10/20/c_129975312.htm"},{"code":null,"contentId":"5ce87d78051548169720c707fc6e529b","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"2014新版首页频道","title":"
  <font color="red">雄安</font>新区华北最近出海通道天津东段动工","url":"http://www.xinhuanet.com/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"e30b6937dc8c42e1be84ea43d44c2e11","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"手机新华网2016","title":"
  <font color="red">雄安</font>新区华北最近出海通道天津东段动工","url":"http://m.xinhuanet.com/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"372f57f484234f9a918c37e3aa5c9385","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"财经频道","title":"
  <font color="red">雄安</font>新区华北最近出海通道天津东段动工","url":"http://www.xinhuanet.com/fortune/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"f04460b2b3d647198f010ee4e9216494","des":null,"imgUrl":"xhpic001/M01/5D/20/wKhTg1vJ7NwEAAAAAAAAAAAAAAA807.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:38:23","sitename":"雄安中文官网","title":"【视频】
  <font color="red">雄安</font>新区容东片区智能城市专项规划开始招标","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975812.htm"},{"code":null,"contentId":"81716f7f23c0410e9e3e7bd160979fbf","des":null,"imgUrl":"xhpic001/M04/5E/BD/wKhTglvJ6_IEAAAAAAAAAAAAAAA029.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:38:08","sitename":"雄安中文官网","title":"【视频】
  <font color="red">雄安</font>新区智能交通专项规划编制工作启动","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975813.htm"},{"code":null,"contentId":"82c73f2ba59842b693cc4d6f7aeff228","des":null,"imgUrl":"xhpic001/M09/5D/20/wKhTg1vJ7NsEAAAAAAAAAAAAAAA210.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:37:46","sitename":"雄安中文官网","title":"【
  <font color="red">雄安</font>之声】20181019","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975811.htm"},{"code":null,"contentId":"faab6c48f87141708354872b0a56b528","des":"10月19日，由雄安创业会客厅、京雄直通车（北京）咨询有限公司联合主办的“汇聚雄安&nbsp;孵化梦想”第十期雄安创业会客厅主题沙龙在雄安市民服务中心举行。","imgUrl":null,"keyword":"雄安新区;创业会客厅;主题沙龙","listResult":null,"pubtime":"2018-10-19 20:49:27","sitename":"雄安中文官网","title":"“汇聚
  <font color="red">雄安</font>&nbsp;孵化梦想”第十期
  <font color="red">雄安</font>创业会客厅主题沙龙举行","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975684.htm"},{"code":null,"contentId":"67080440e13e4760b58090c6101fce35","des":"10月19日，雄安新区雄县雄州镇组织召开了“走遍雄安”活动动员大会，标志着雄县雄州镇成为雄安新区首个启动“走遍雄安”活动的乡镇，打响了“走遍雄安”活动第一枪。","imgUrl":null,"keyword":"雄安新区;生态环境局;雄州镇;走遍雄安;动员大会","listResult":null,"pubtime":"2018-10-19 20:48:23","sitename":"雄安中文官网","title":"
  <font color="red">雄安</font>新区
  <font color="red">雄</font>县
  <font color="red">雄</font>州镇率先启动“走遍
  <font color="red">雄安</font>”活动","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975763.htm"}],"pageCount":711,"resultCount":7103}}
 </body>
</html>
*/

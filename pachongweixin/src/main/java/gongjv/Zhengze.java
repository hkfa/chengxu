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
			System.out.println("ԭ�ַ�"+allStrings);
			System.out.println("ƥ���ַ�"+result);
	}

}
/*<html>
 <head></head>
 <body>
  {"code":200,"content":{"recommendation":null,"keyword":"�۰�","sortField":"0","optionsSearchTypes":null,"curPage":2,"results":[{"code":null,"contentId":"849706900ac54f2d96a3e219cba34cd4","des":"�ӱ�ʡ�����칫������ӡ�������ڼ�ǿʡ�Ὺ�������ʵʩ�������ȷ��Ҫץס���ҹ滮�����۰������Ļ����������ƽ�ʡ�����۰�����Эͬ��չ�����۰�������ͬ�걨���Ҽ����Ŵ����Ե㣬��̽�������;������й�����ģʽ������Ͷ�ʺ����·�ʽ����������Ч������ó����ϵ�ȷ���ȡ��ͻ�ƣ���ͬ������½���Ŵ��¸ߵء�","imgUrl":null,"keyword":"�۰�����;�����Ե�;��ó������","listResult":null,"pubtime":"2018-10-20 11:09:09","sitename":"�۰����Ĺ���","title":"�ӱ������ƽ�ʯ��ׯ��
  <font color="red">�۰�</font>������ͬ�걨���Ҽ����Ŵ����Ե�","url":"http://www.xiongan.gov.cn/2018-10/20/c_129975986.htm"},{"code":null,"contentId":"084628ec032d4ecc8a7bb1f0ece805f3","des":"̽�õ�һ��ӱ����ʹ�ҵ����ܣ���������߽������ȷ���ƿƼ�����ݡ�","imgUrl":null,"keyword":"�ӱ�;��ҵ;�����;̽��","listResult":null,"pubtime":"2018-10-20 11:02:20","sitename":"�۰����Ĺ���","title":"��ҵ����������飺
  <font color="red">�۰�</font>��������","url":"http://www.xiongan.gov.cn/2018-10/20/c_129975312.htm"},{"code":null,"contentId":"5ce87d78051548169720c707fc6e529b","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"2014�°���ҳƵ��","title":"
  <font color="red">�۰�</font>���������������ͨ����򶫶ζ���","url":"http://www.xinhuanet.com/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"e30b6937dc8c42e1be84ea43d44c2e11","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"�ֻ��»���2016","title":"
  <font color="red">�۰�</font>���������������ͨ����򶫶ζ���","url":"http://m.xinhuanet.com/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"372f57f484234f9a918c37e3aa5c9385","des":null,"imgUrl":null,"keyword":null,"listResult":null,"pubtime":"2018-10-20 09:54:46","sitename":"�ƾ�Ƶ��","title":"
  <font color="red">�۰�</font>���������������ͨ����򶫶ζ���","url":"http://www.xinhuanet.com/fortune/2018-10/20/c_1123587071.htm"},{"code":null,"contentId":"f04460b2b3d647198f010ee4e9216494","des":null,"imgUrl":"xhpic001/M01/5D/20/wKhTg1vJ7NwEAAAAAAAAAAAAAAA807.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:38:23","sitename":"�۰����Ĺ���","title":"����Ƶ��
  <font color="red">�۰�</font>�����ݶ�Ƭ�����ܳ���ר��滮��ʼ�б�","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975812.htm"},{"code":null,"contentId":"81716f7f23c0410e9e3e7bd160979fbf","des":null,"imgUrl":"xhpic001/M04/5E/BD/wKhTglvJ6_IEAAAAAAAAAAAAAAA029.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:38:08","sitename":"�۰����Ĺ���","title":"����Ƶ��
  <font color="red">�۰�</font>�������ܽ�ͨר��滮���ƹ�������","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975813.htm"},{"code":null,"contentId":"82c73f2ba59842b693cc4d6f7aeff228","des":null,"imgUrl":"xhpic001/M09/5D/20/wKhTg1vJ7NsEAAAAAAAAAAAAAAA210.jpg","keyword":null,"listResult":null,"pubtime":"2018-10-19 22:37:46","sitename":"�۰����Ĺ���","title":"��
  <font color="red">�۰�</font>֮����20181019","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975811.htm"},{"code":null,"contentId":"faab6c48f87141708354872b0a56b528","des":"10��19�գ����۰���ҵ�����������ֱͨ������������ѯ���޹�˾��������ġ�����۰�&nbsp;�������롱��ʮ���۰���ҵ���������ɳ�����۰�����������ľ��С�","imgUrl":null,"keyword":"�۰�����;��ҵ�����;����ɳ��","listResult":null,"pubtime":"2018-10-19 20:49:27","sitename":"�۰����Ĺ���","title":"�����
  <font color="red">�۰�</font>&nbsp;�������롱��ʮ��
  <font color="red">�۰�</font>��ҵ���������ɳ������","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975684.htm"},{"code":null,"contentId":"67080440e13e4760b58090c6101fce35","des":"10��19�գ��۰�����������������֯�ٿ��ˡ��߱��۰������Ա��ᣬ��־�������������Ϊ�۰������׸��������߱��۰���������򣬴����ˡ��߱��۰������һǹ��","imgUrl":null,"keyword":"�۰�����;��̬������;������;�߱��۰�;��Ա���","listResult":null,"pubtime":"2018-10-19 20:48:23","sitename":"�۰����Ĺ���","title":"
  <font color="red">�۰�</font>����
  <font color="red">��</font>��
  <font color="red">��</font>���������������߱�
  <font color="red">�۰�</font>���","url":"http://www.xiongan.gov.cn/2018-10/19/c_129975763.htm"}],"pageCount":711,"resultCount":7103}}
 </body>
</html>
*/

package shili;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.Model;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyPipeline implements Pipeline{

	public void process(ResultItems resultItems, Task task) {
		
		String resource="configuration.xml";
		try{
			Reader reader=Resources.getResourceAsReader(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession=factory.openSession();
		Set<Map.Entry<String,Object>> entrys=resultItems.getAll().entrySet();
		for(Map.Entry<String,Object> entry:entrys){
			if(entry.getKey().equals("xinhua")){
				Model model=(Model) entry.getValue();
				if(model!=null&&(model.getContent()!=null))
				{	sqlSession.insert("insert", model);
		
				sqlSession.commit();}
				sqlSession.close();
			}
		}
		}catch(IOException e){System.out.println(e.getStackTrace());}
		
	}
}






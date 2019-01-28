package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	
	public  List<Test> getAllDocuments ()throws  IOException{
		String resource="configuration.xml";
		Reader reader=Resources.getResourceAsReader(resource);
		List<Test> allDocs=new ArrayList<Test> ();
	SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession sqlSession=sqlSessionFactory.openSession();
	Test test1=sqlSession.selectOne("test.selectTestById",3);
	 allDocs=sqlSession.selectList("test.selectTestByIds");
	//System.out.println(test1.getTitle());
	//System.out.println(allDocs.size());//2968
	sqlSession.close();
	return allDocs;
	}
}

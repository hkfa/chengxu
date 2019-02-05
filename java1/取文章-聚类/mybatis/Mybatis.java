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
	
	public static  List<Test> getAllDocs()throws IOException{
		String resource="configuration.xml";
		Reader reader=Resources.getResourceAsReader(resource);
		List<Test> test1;
	SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession sqlSession=sqlSessionFactory.openSession();
	Test test=sqlSession.selectOne("test.selectTestById",2);
	 test1=sqlSession.selectList("test.selectTestByIds");
	//System.out.println(test1);
	sqlSession.close();
	return test1;
	}
}

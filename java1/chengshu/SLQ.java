package weixinde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
public class SLQ {
public static void main(String []args) throws ClassNotFoundException{

		
		Connection connection=null;
		String driver="com.mysql.jdbc.Driver";   
		String dbURL="jdbc:mysql://127.0.0.1:3306/free?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
		String user = "root";
		String password = "666";
		Class.forName(driver);  
		try {
			connection = DriverManager.getConnection(dbURL,user,password);
			if(!connection.isClosed()){
				System.out.println("sucess");			}

			String sql=""
					+ "insert into test1"
					+ "(title,age)"
					+ "values(?,?)";//我们使用占位符
			PreparedStatement state = connection.prepareStatement(sql);
   // System.out.println(test.gettitle());
		//	state.setString(1,test.gettitle() );
			state.setInt(2,7);

			state.execute();
			System.out.print(state);


		} catch (SQLException e) {
			e.printStackTrace();
		}     
	}
}


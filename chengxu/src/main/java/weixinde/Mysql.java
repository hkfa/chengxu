package weixinde;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mysql {
	class DB{
		public void sql()throws  SQLException,ClassNotFoundException, IOException{
			  Connection connection=null;
			String driver="com.mysql.jdbc.Driver";   
			String dbURL="jdbc:mysql://127.0.0.1:3306/free?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
			String user = "root";
			String password = "666";
			Class.forName(driver);  

			connection = DriverManager.getConnection(dbURL,user,password);
			if(!connection.isClosed()){
				System.out.println("sucess");			}

			String sql=""
					+ "insert into test2"
					+ "(title,age)"
					+ "values(?,?)";//我们使用占位符
			PreparedStatement state = connection.prepareStatement(sql);
			//dinsh test2=new dinsh();
		//	System.out.println(test2.parse());
			//state.setString(1,test2.parse() );
			state.setInt(2,7);

			state.execute();
			System.out.print(state);


		}


	}
	class Model{
		private String title;
		public void settitle(String title){
			this.title=title;
		}
		public String gettitle(){
			return title;
		}
	}


}

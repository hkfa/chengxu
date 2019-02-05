package weixinde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement;

public class test {
	public static void main(String []args){
	 Connection con = null;  
	  PreparedStatement pst = null;  
	    
	  String url = "jdbc:mysql://localhost:3306/";  
	  String db = "free?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
	  String driver = "com.mysql.jdbc.Driver";  
	  String user = "root";  
	  String pass = "666";  
	  
	  try {  
	  Class.forName(driver);  
	  con = DriverManager.getConnection(url + db, user, pass);  
	  con.setAutoCommit(false);// Disables auto-commit.  
	  
	  String sql = "insert into test1 values(?,?) ";  
	  pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
	  
	  pst.setString(1, "Rakesh");  
	  pst.setString(2, "18");  
	  pst.executeUpdate();  
	  pst.close();  
	  con.close();  
	  
	  } catch (Exception e) {  
	  System.out.println(e);  
	  }  
	  }  
	 
}

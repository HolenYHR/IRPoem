package db;
import java.sql.Connection;  
import java.sql.DriverManager;  
public class Database {
	
	  
	
	  
	 public static Connection getConnection(){//用这个方法获取mysql的连接  
	     Connection conn=null;  
	     try{  
	         Class.forName("com.mysql.jdbc.Driver");//加载驱动类  
	         conn=DriverManager.     
	                 getConnection("jdbc:ssss","xxxx","xxxx");//（url数据库的IP地址，user数据库用户名，password数据库密码）  
	     }catch(Exception e){  
	         e.printStackTrace();  
	     }  
	     return conn;  
	 }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=Database.getConnection();  
        System.out.println(conn);  
	}

}

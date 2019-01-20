package live.xjames.database;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBA {
	
	private final String address = "xx.xx.xx.xxx";
	private final String database = "xxx";
	private final String port = "3306";
	private final String username = "root";
	private final String password = "xxx";

	 public Connection getConnection(){
		  try{
		   String driver = "com.mysql.jdbc.Driver";
		   String url = "jdbc:mysql://" + address + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";
		   Class.forName(driver);
		   
		   Connection conn = DriverManager.getConnection(url,username,password);
		   return conn;
		  } catch(Exception e){System.out.println(e);}
		  return null;
		 }
	 
}

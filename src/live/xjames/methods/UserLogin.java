package live.xjames.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import live.xjames.database.*;

public class UserLogin {

	private String username;
	private String password;
	private String partnerid;
	// 1d: partnerid 2d: nickname
	private String[][] partners;
	
	private DBA db = new DBA();
	private Connection connection = db.getConnection(); 
	
	private boolean loggedin = false;
	
	public UserLogin(boolean rem, String un, String p) {
		username = un;
		password = p;
		try{System.out.println(checkLogin());}catch (SQLException e) {e.printStackTrace();}
		System.out.println(password);
		
		if (rem) {}
		if (loggedin) {}
		
		
		try {connection.close();} catch (SQLException ex) {ex.printStackTrace();}
	}
	
	private boolean checkLogin() throws SQLException {
		 PreparedStatement getName = connection.prepareStatement("SELECT userid FROM level WHERE userid=''"); 
		 ResultSet res = getName.executeQuery();
		 try{if(res.first()) return true;
			 else return false;
		 } finally {}
	}
	
	
	
}

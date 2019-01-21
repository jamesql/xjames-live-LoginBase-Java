package live.xjames.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import live.xjames.database.*;
import live.xjames.frame.application;
import live.xjames.frame.login;

public class UserLogin {

	private String username;
	private String password;
	private String partnerid;
	// 1d: partnerid 2d: nickname
	private String[][] partners;
	
	private DBA db = new DBA();
	private Connection connection = db.getConnection(); 
	
	private boolean loggedin = false;
	
	public UserLogin(String un, String p, login screen) {
		username = un;
		password = p;
		try{loggedin = checkLogin();}catch (SQLException e) {e.printStackTrace();}
		
		if (loggedin) {
			screen.disappear();
			// passing user login details for use in application
			application newapp = new application(this);
		}
		
		
		try {connection.close();} catch (SQLException ex) {ex.printStackTrace();}
	}
	
	private boolean checkLogin() throws SQLException {
		 PreparedStatement getName = connection.prepareStatement("SELECT * FROM users WHERE username='" + username + "'"); 
		 ResultSet res = getName.executeQuery();
		 try{if(res.first() && res.getString("password").equals(password)) return true;
			 else return false;
		 } finally {}
	}
	
	
	
}

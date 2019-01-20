package live.xjames.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import live.xjames.database.*;

import com.larry.sha256.*;

public class RegisterUser {

	private String username;
	private String password;
	private String partnerid;
	
	private DBA db = new DBA();
	private Connection connection = db.getConnection(); 
	
	private boolean exists = false;
	
	public RegisterUser(boolean rem, String un, String p) {
		username = un;
		password = p;
		try {
			exists = checkUsername();
		} catch (SQLException e) {e.printStackTrace();}
		
		if (exists) sendFail("Username already exists!");
		else try{register();}catch(SQLException e){e.printStackTrace();}
		
		
		try {connection.close();} catch (SQLException ex) {ex.printStackTrace();}
	}
	
	private boolean checkUsername() throws SQLException {
		 PreparedStatement getName = connection.prepareStatement("SELECT username FROM users WHERE username='" + username + "'"); 
		 ResultSet res = getName.executeQuery();
		 res.first();
		 try{if(res.getString("username").equals(username) && res.first()) return true;
			 else return false;
		 } finally {}
	}
	
	private String getPartnerId() {
		Hash hash = new Hash();
		hash.newHash(username);
		return hash.getEncrypted();
	}
	
	private void register() throws SQLException {
		 PreparedStatement state = connection.prepareStatement("INSERT INTO users (username,password,partnerid) VALUES ('" + username + "','" + password + "','" + getPartnerId().substring(3, 10) + "')");
		 state.execute();
	}
	
	private void sendFail(String reason) {
		
	}
	
	
}

package live.xjames.frame;

import javax.swing.*;
import live.xjames.methods.UserLogin;
import java.awt.event.*;
import com.larry.sha256.*; 

public class login implements ActionListener{

	private JFrame frame;
	private JTextField userLogin;
	private JPasswordField userPassword;
	private JButton loginButton;
	private JCheckBox rememberMe;
	private UserLogin ul;
	
	public login() {
		init();
	}
	
	
	// Init Frame
	public void init() {
		frame = new JFrame("SendIt - Login");
		frame.setBounds(50, 50, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		// Components
		userLogin = new JTextField("Username");
		userPassword = new JPasswordField("Password");
		userLogin.setBounds(100, 30, 300, 30);
		userPassword.setBounds(100, 80, 300, 30);
		frame.getContentPane().add(userLogin);
		frame.getContentPane().add(userPassword);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(100, 150, 300, 60);
		loginButton.addActionListener(this);
		
		rememberMe = new JCheckBox("Remember Me");
		rememberMe.setBounds(100, 220, 300, 30);
		
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(rememberMe);
		
	}
	

	public void appear() {
		frame.setVisible(true);
	}
	
	public void disappear() {
		frame.setVisible(false);
	}
	
	private String hash() {
		Hash hash = new Hash();
		hash.newHash(userPassword.getText());
		return hash.getEncrypted();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(loginButton)) {
			if (rememberMe.isSelected()) ul = new UserLogin(true, userLogin.getText(), hash());
			else ul = new UserLogin(false, userLogin.getText(), hash());
		}
	}
	
}

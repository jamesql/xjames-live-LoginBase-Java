package live.xjames.frame;

import javax.swing.*;
import live.xjames.methods.UserLogin;
import live.xjames.typewriter.remember;

import java.io.*;
import java.util.Scanner;

import java.awt.event.*;
import com.larry.sha256.*; 

public class login implements ActionListener {

	
	private String fileDir = "tmp.txt";
	private JFrame frame;
	private JTextField userLogin;
	private JPasswordField userPassword;
	private JButton loginButton;
	private JButton registerr;
	private JCheckBox rememberMe;
	@SuppressWarnings("unused")
	private UserLogin ul;
	private register rg;
	
	private File details = new File(fileDir);
	
	public login() {
		try{init();}catch(FileNotFoundException e){e.printStackTrace();}
	}
	
	
	// Init Frame
	public void init() throws FileNotFoundException {
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
		registerr = new JButton("Register");
		registerr.setBounds(300, 220, 100, 60);
		registerr.addActionListener(this);
		
		rememberMe = new JCheckBox("Remember Me");
		rememberMe.setBounds(100, 220, 300, 30);
		
		if (details.exists()) {
			Scanner s = new Scanner(details);
			userLogin.setText(s.next());
			userPassword.setText(s.next());
		}
		
		frame.getContentPane().add(registerr);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(rememberMe);
		
	}
	

	public void appear() {
		frame.setVisible(true);
	}
	
	public void disappear() {
		frame.setVisible(false);
	}
	
	@SuppressWarnings("deprecation")
	private String hash() {
		Hash hash = new Hash();
		hash.newHash(userPassword.getText());
		return hash.getEncrypted();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(loginButton)) {
			if (rememberMe.isSelected()) {
				remember rm = new remember(userLogin.getText(), userPassword.getText());
				ul = new UserLogin(userLogin.getText(), hash(), this);
			}
			else ul = new UserLogin(userLogin.getText(), hash(), this);
		}
		
		if (event.getSource().equals(registerr)) {
			rg = new register();
			rg.appear();
		} 
	}
	
}

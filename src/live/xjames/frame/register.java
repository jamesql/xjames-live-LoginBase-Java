package live.xjames.frame;

import javax.swing.*;

import live.xjames.methods.RegisterUser;
import java.awt.event.*;
import com.larry.sha256.*; 

public class register implements ActionListener {

	private JFrame frame;
	private JTextField userLogin;
	private JPasswordField userPassword;
	private JButton regButton;
	private JCheckBox rememberMe;
	@SuppressWarnings("unused")
	private RegisterUser ul;
	
	public register() {
		init();
	}
	
	
	// Init Frame
	public void init() {
		frame = new JFrame("SendIt - Register");
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
		
		regButton = new JButton("Register");
		regButton.setBounds(100, 150, 300, 60);
		regButton.addActionListener(this);
		
		rememberMe = new JCheckBox("Remember Me");
		rememberMe.setBounds(100, 220, 300, 30);
		
		frame.getContentPane().add(regButton);
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
		if (event.getSource().equals(regButton)) {
			if (rememberMe.isSelected()) ul = new RegisterUser(true, userLogin.getText(), hash());
			else ul = new RegisterUser(false, userLogin.getText(), hash());
			disappear();
		}
	}
	
}

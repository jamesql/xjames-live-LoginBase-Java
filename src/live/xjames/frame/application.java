package live.xjames.frame;

import javax.swing.*;

import live.xjames.methods.UserLogin;

public class application {

	private JFrame application;
	private UserLogin details;
	
	public application(UserLogin ul) {
		detials = ul;
		init();
	}
	
	public void init(){
		application = new JFrame("SendIt");
		application.setBounds(500, 500, 250, 600);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
		application.setLayout(null);
		application.setResizable(false);
	}
	
}

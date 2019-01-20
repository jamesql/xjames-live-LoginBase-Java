package live.xjames.frame;

import javax.swing.*;

public class application {

	private JFrame application;
	
	public application() {
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

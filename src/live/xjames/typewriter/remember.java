package live.xjames.typewriter;

import java.io.*;

public class remember {

	private String filePath = "tmp.txt";
	
	private String un;
	private String pass;
	
	private File text = new File(filePath);
	private PrintWriter log;
	
	public remember(String username, String password) {
		un = username;
		pass = password;
		startMemory();
	}
	
	private void startMemory() {
		if (text.exists()) {
			text.delete();
			try{text.createNewFile();}catch (IOException e) {e.printStackTrace();}
			writeMemory();
		}else {
			try{text.createNewFile();}catch (IOException e) {e.printStackTrace();}
			writeMemory();
		}
	}
	
	private void writeMemory() {
		try {log = new PrintWriter(text);} catch (FileNotFoundException e) {e.printStackTrace();}
		log.print(un + "\n" + pass);
		log.close();
	}
	
}

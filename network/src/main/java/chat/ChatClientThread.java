package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	
	private Socket socket;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			while (true) {
				String data = br.readLine();
				System.out.println(data);
			}
			
		} 
		catch (IOException e) {
			System.out.println("퇴장하셨습니다.");
		}
		
	}

	
	
	
	
	
	
	
}

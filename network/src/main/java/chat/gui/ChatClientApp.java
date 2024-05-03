package chat.gui;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	private static Socket socket;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
	
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("0.0.0.0",ChatServer.PORT));
			
			new ChatWindow(name, socket).show();
		}
		catch(IOException e) {
			System.out.println("fail to connect server");
		}
		
	}

}

package chat;

	
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		Socket socket = null;
		try {
			//1. connect keyboard
			scanner = new Scanner(System.in);
			
			//2. create socket
			socket = new Socket();
			//3. connect
			socket.connect(new InetSocketAddress("0.0.0.0", ChatServer.PORT));
			//4. create r/w
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			//5. join protocol
			System.out.println("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();
			
			//6. chatclientreceivethread start
			new ChatClientThread(socket).start();
			
			//7. input keyboard exe
			while (true) {
				System.out.println(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					//8. quit protocol
					pw.println("quit:" + nickname);
					break;
				}
				else {
					//9. message
					pw.println("message" + ":" + input);
					continue;
				}
			}
		} 
		
		catch (IOException e) {
			System.out.println();
		}
		finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			}
			catch (IOException e) {
				System.out.println("error :  "+ e);
			}
		}
	}

}

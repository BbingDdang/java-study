package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			scanner = new Scanner(System.in);
			//Basic Structure
			
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				System.out.println(">>");
				String line = scanner.nextLine();
				if ("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine(); // blocking
				if (data == null) {
					log("suddenly closed by server");
					break;
				}
				System.out.println("<<" + data);
					
			}
		} 
		catch (IOException e) {
			log("error" + e);
		}
		finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				log("error" + e);
			}
		}
		
		
		
	}
	public static void log(String message) {
		System.out.println("[EchoClient] : ");
	}

}
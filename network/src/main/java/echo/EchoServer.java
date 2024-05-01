package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 6000;
	
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			
			serverSocket = new ServerSocket();
			
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 6000), 10);
			
			
			Socket socket = serverSocket.accept(); 
			
			System.out.println("Connect!!");
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // get ip address to string 
				int remotePort = inetRemoteSocketAddress.getPort();
				log("[EchoServer] connected by client["+remoteHostAddress + ":" + remotePort + "]");
				
//				
//				InputStream is = socket.getInputStream();
//				OutputStream os = socket.getOutputStream();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				
				while(true) {
					String data = br.readLine(); // blocking
					if(data == null) {
						log("closed by client");
						break;
					}
					log("received : " + data);
					
					pw.println(data);
				
				
					
					
				}
			} 
			catch (SocketException e) {
				log("suddenly closed by client" + e);
				
			}
			catch (IOException e) {
				log("[server] error : " + e);
			}
			finally {
			
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
					
		} 
		catch (IOException e) {
			log("[server] error : " + e);
		}
		finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}

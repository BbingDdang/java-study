package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. Server Socket 생성
			serverSocket = new ServerSocket();
			//1-1. FIN_WAIT2 -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록하기 위해
			serverSocket.setReuseAddress(true);
			
			//2. Binding 
			//	 Binding InetSocketAddress[InetAddress(IPAddress) + Port] in Socket
			// 	 IPAdress: 0.0.0.0 : 특정 호스트 IP 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5002), 10);
			
			//3. Accept
			Socket socket = serverSocket.accept(); // blocking
			
			System.out.println("Connect!!");
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress(); // get ip address to string 
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client["+remoteHostAddress + ":" + remotePort + "]");
				
				//4. Get IO Stream
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				//5. Read Data
				while(true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					
					if (readByteCount == -1) {
						// Finished client normally (Called close())
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received : " + data);
					
					//6.Write Data
					//SO_TIMEOUT test
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					
					os.write(data.getBytes("UTF-8"));
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
			} 
			catch (SocketException e) {
				System.out.println("[server] Socket Exception : " + e);
				
			}
			catch (IOException e) {
				System.out.println("[server] error : " + e);
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
			System.out.println("[server] error : " + e);
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

}


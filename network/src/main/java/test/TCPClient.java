package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5002;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			//1. Create Socket
			socket = new Socket();
			
			//2. Connect Server
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//3. Receive IO Stream
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. Write
			String data = "Hello World";
			os.write(data.getBytes("UTF-8"));
			
			//5. Read
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "UTF-8"); // inputreadbuffer? 을 통해 활용가능 
			System.out.println("[client] received : " + data);
		}
		catch (SocketException e) {
			System.out.println("[client] suddenly closed by server");
		}
		catch (IOException e) {
			System.out.println("[client] error : " + e);
		}
		finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				System.out.println("x");
			}
		}
	}

}

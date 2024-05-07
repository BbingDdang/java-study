package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final int PORT = 6000;
	private static final String SERVER_IP = "127.0.0.1";
	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;
		
		try {
			//1. create Scanner
			scanner = new Scanner(System.in);
			
			//2. create Socket
			socket = new DatagramSocket();
			
			while (true) {
				System.out.println(">");
				String message = scanner.nextLine();
				
				if ("quit".equals(message)) {
					break;
				}
				
				//3. Send
				byte[] sndData = message.getBytes("UTF-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, new InetSocketAddress(SERVER_IP, UDPEchoServer.PORT));
				socket.send(sndPacket);
				
				//4. receive
				DatagramPacket rcvPacket = new DatagramPacket(new byte[UDPEchoServer.BUFFER_SIZE], UDPEchoServer.BUFFER_SIZE);
				socket.receive(rcvPacket); //blocking
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				message = new String(rcvData, 0, offset, "UTF-8");
				
				System.out.println("<" + message);
			}
			
			
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("[UDP Echo Client] error : " + e);
		}
		catch (IOException e) {
			System.out.println("[UDP Echo Client] error : " + e);
		}
		finally {
			if(scanner != null) {
				scanner.close();
			}
			
			if(socket != null && !socket.isClosed()) {
				
			}
		}
				
	}

}

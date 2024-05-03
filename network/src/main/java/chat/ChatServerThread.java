package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {
	private List<Writer> listWriters;
	private String nickname;
	private Socket socket;
	private PrintWriter pw;
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while(true) {
				String data = br.readLine(); // blocking
				if(data == null) {
					log("closed by client");
					break;
				}
				log("received : " + data);
				
				//pw.println(data);
			
				System.out.println(data);
				String[] tokens = data.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				}	
				else if ("message".equals(tokens[0])) {
					byte[] decodedBytes = Base64.getDecoder().decode(tokens[1]);
					String str = new String(decodedBytes);
					doMessage(str);
				}
				else if ("quit".equals(tokens[0])) {
					doQuit();
				}
				else {
					log("에러:알수 없는 요청 (" + tokens[0] + ")");
				}
				
			}
			
			
		} 
		catch(SocketException e) {
			log("error : " + e);
			
		}
		catch (IOException e) {
			log("error : " + e);
		}
		finally {
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} 
			catch( IOException ex ) {
				log( "error:" + ex );
			}
			listWriters.remove(this);
		}
	}
	private void doQuit() {
		
		String data = nickname + "님이 퇴장 하였습니다.";
		broadCast(data);
		removeWriter(pw);
		
	}


	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String string) {
		//log(nickname + ":" + string + "\r\n");
		//System.out.println(nickname + ":" + string + "\r\n");
		broadCast(nickname + ":" + string);
		
	}

	private void doJoin(String string, PrintWriter pw) {
		this.nickname = string;
		String data = nickname + "님이 참여하였습니다.";
		broadCast(data);
		addWriter(pw);
		
		
		//ack
		//pw.println("join:ok");
		//pw.flush();
		
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
		
	}

	private void broadCast(String data) {
		synchronized(listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
		
	}

	private static void log(String message) {
		System.out.println("[ChatServer] " + message);
	}
}

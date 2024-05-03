package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatWindow {
	//socket
	private Socket socket;
	private PrintWriter writer;
	private Frame frame; 			//밖에있는 큰 윈도우 
	private Panel pannel; 			//
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String nickname;
	// 생성자 socket 추
	public ChatWindow(String name, Socket socket) {
		this.socket = socket;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.nickname = name;
		try {
			this.writer = new PrintWriter(socket.getOutputStream(), true); 
		}
		catch(IOException e) {
			System.out.println("failed connection");
		}
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// click event
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				//System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//iostream 받아오기
		//chatclientthread 생성
		
		
		this.writer.println("join:"+nickname);
		//this.writer.flush();
		textArea.append(nickname + "님이 입장하셨습니다.\n");
		new ChatClientThread().start();
	}
	
	protected void finish() {
		// quit protocol 구현
		//exit java application
		try {
			this.writer.println("quit:"+this.nickname);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		
	}

	private void sendMessage() {
		String message = textField.getText();
		if(!message.isEmpty()) {
			if("quit".equals(message)) {
				finish();
			}
			else {
				this.writer.println("message:" + message);
				//this.writer.flush();	
			}
			
			//updateTextArea(message);
			textField.setText("");
			textField.requestFocus();
			
		}
		
		
		// chatclientthread에서 서버로 부터 받은 메세지가 있다고 치고
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");		
	}

	private class ChatClientThread extends Thread {
		
		@Override
		public void run() {
			//String message = br.readline();
			//updateTextArea("마이콜 : " + message);
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				
				while (true) {
					String data = br.readLine();
					
					if(data == null) {
						break;
					}
					//String[] tokens = data.split(":");
					
					updateTextArea(data);
					
					
				}
			}
			catch (IOException e) {
				System.out.println("퇴");
			}
				
			
		}
	}
	
}

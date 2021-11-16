package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	
	public static final String IP = "192.168.1.192";
	public static final int PORT = 5001;
	
	// 서버로 출력하는 스트림
	PrintWriter pw;
	// 서버에서 입력받는 스트림
	BufferedReader br;
	// Console 에서 입력받는 스트림
	BufferedReader read;
	
	// server에 대한 정보를 저장하는 Socket
	Socket server;
	// 입력 flag
	boolean isRun =true;
	
	ChatClient(){
		try {
			connect();
		} catch (Exception e) {
			System.out.println("Server 연결 안됨.");
		}
	}
	
	// 서버와 연결
	public void connect() throws Exception{
		System.out.println("********* 클라이언트 ***********");
		System.out.println("연결요청 : "+IP+":"+PORT);
		server = new Socket(IP,PORT);
		String serverIP = server.getInetAddress().getHostAddress();
		System.out.println("연결 성공 : "+serverIP);
		
		read = new BufferedReader(new InputStreamReader(System.in));
		
		br = new BufferedReader(new InputStreamReader(server.getInputStream()));
		
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(server.getOutputStream())),true);
		
		receive();
		System.out.println("사용할 이름을 입력해 주세요");
		while (isRun) {
			// Console에서 사용자가 입력한 data를 일겅옴
			String sendData = read.readLine();
			// 사용자가 입력한 data를 서버에 출력(전달)
			pw.println(sendData);
		}
	}
	
	// server에서 메세지 수신
	public void receive() {
		Thread t = new Thread(()->{
			while (true) {
				String receiveData;
				try {
					if ((receiveData = br.readLine()) != null) {
						System.out.println(receiveData);
					}
				} catch (IOException e) {
					System.out.println("Server 통신오류 : " + e.getMessage());
					if (server != null && !server.isClosed()) {
						try {
							server.close();
							System.out.println("서버 닫힘");
						} catch (IOException e1) {}
					}
					isRun=false;
					break;
				}
			}
		});
		t.start();
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}








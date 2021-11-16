package n3_echo_chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
	
	Scanner sc = new Scanner(System.in);
	Socket socket;
	
	ClientExample(){
		startClient();
	}
	// server에서 메세지를 전달 받음.
	public void receive() {
		Thread t = new Thread(()->{
			while(true) {
				InputStream is = null;
				
				try {
					is = socket.getInputStream();
					byte[] bytes = new byte[100];
					int readByte = is.read(bytes);
					String message = new String(bytes,0,readByte,"UTF-8");
					System.out.println(message);
				}catch (IOException e) {
					try {
						if(is != null) is.close();
					} catch (IOException e1) {}
					stopClient();
					break;
				}
			}
		});
		t.start();
	}
	
	// Server에 message 전달
	public void send(String message) {
		OutputStream os = null;
		try {
			byte[] bytes = message.getBytes("UTF-8");
			os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		} catch (IOException e) {
			System.out.println("서버 통신 안됨.");
			try {
				if(os != null)os.close();
			} catch (IOException e1) {}
			stopClient();
			return;
		}
	}
	
	// Client 시작 - Server와 연결및 Socket 생성
	public void startClient() {
		try {
			socket = new Socket("192.168.1.99",5002);
			/*
			socket.connect(
				new InetSocketAddress("192.168.1.99",5002)
			);
			*/
			System.out.println("연결 완료 : "+socket.getRemoteSocketAddress());
			receive();
			while(true) {
				System.out.print("메세지 입력 : ");
				String message = sc.nextLine();
				send(message);
			}
		} catch (IOException e) {
			System.out.println("서버와 통신 안됨 : "+e.getMessage());
			stopClient();
			return;
		}
	}
	
	// client 종료 - 자원해제
	public void stopClient() {
		System.out.println("연결 종료");
	// socket이 생성되어져 있고 서버와 연결이 되어있는 상태
	// 일때 소켓 닫음.
		if(socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
	}

	public static void main(String[] args) {
		new ClientExample();
	}

}








package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
	
	public static final String IP ="192.168.1.192";
	public static final int PORT = 5001;
	
	ServerSocket serverSocket; // client 연결 수락및 정보확인
	
	// client 들의 정보 저장
	// id(key) , 출력 스트림(value)
	static Hashtable<String,PrintWriter> ht;
	// thread pool
	static ExecutorService serverPool; 
	
	public ChatServer() {
		try {
			serverPool = Executors.newFixedThreadPool(30);
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP,PORT));
		} catch (IOException e) {
			System.out.println("bind 할 수 없는 IP 또는 PORT 입니다."+e.getMessage());
			return;
		}
		ht = new Hashtable<>();
		System.out.println("********* 채팅 서버 오픈 *********");
		while(true) {
			try {
				System.out.println("[ Client 연결 기다리는 중... ]");
				Socket client = serverSocket.accept();
				String clientIP = client.getInetAddress().getHostAddress();
				System.out.println(clientIP+"-연결수락");
				new ServerTask(client);
			} catch (IOException e) {
				System.out.println("Server 통신 오류 : "+e.getMessage());
				ht.clear();
				serverPool.shutdownNow();
				if(serverSocket != null && !serverSocket.isClosed()) {
					try {
						serverSocket.close();
					} catch (IOException e1) {}
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}









package n2_socket_serverSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		try {
			//ServerSocket server = new ServerSocket(5001);
			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress("192.168.1.113",5001));
			System.out.println("[서버 오픈]");
			System.out.println("Client 연결 대기중...");
			Socket client = server.accept();
			
			InputStream is = client.getInputStream();
			String message = "";
			byte[] bytes = new byte[100];
			// blocking
			int readCount = is.read(bytes);
			message = new String(bytes,0,readCount,"UTF-8");
			System.out.println(client+" : [데이터 받기 성공 ]"+message);
			
			OutputStream os = client.getOutputStream();
			message = "안녕 클라이언트!";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println(" 서버 데이터 전송 완료 ");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Main 종료");
	}

}











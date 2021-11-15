package n2_socket_server_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		System.out.println("[ 서버에 연결 요청 ]");
		try {
			Socket socket = new Socket("192.168.1.113",5001);
			System.out.println("[ 서버연결완료 ]");
			System.out.println(socket.getRemoteSocketAddress());
			
			OutputStream os = socket.getOutputStream();
			String message = "누가 보낸거게?";
			byte[] bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[ 데이터 전송 완료 ]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			// 서버쪽에서 출력될때까지 blocking
			int readCount = is.read(bytes);
			message = new String(bytes,0,readCount,"UTF-8");
			System.out.println("[ 서버에서 전달받은 메세지 : "+message+" ]");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}








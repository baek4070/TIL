package n3_echo_chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// socket으로 연결된 client의 정보를 저장하고
// 기능을 수행할 클래스
public class Client {
	// 연결된 client socket의 정보를 저장할 socket
	Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
	// 연결된 client에게 메세지를 전달할 메소드
	public void send(String message) {
		OutputStream os = null;
		try {
			byte[] bytes = message.getBytes("UTF-8");
			os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		}catch (IOException e) {
			try {
				System.out.println("Client 통신 안됨");
				if(os != null) {os.close();}
				
				if(socket != null && !socket.isClosed()){
					socket.close();
				}
				ServerExample.clients.remove(this);
			} catch (IOException e1) {}
		}
	}
	
	// client 가 전달하는 메세지를 읽음.
	public void receive() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					InputStream is = null;
					byte[] bytes = new byte[100];
					try {
						is = socket.getInputStream();
						int readBytes = is.read(bytes);
						String sender = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
						String message = "[요청처리 완료 ] - "+sender;
						System.out.println(message);
						String data = new String(bytes,0,readBytes,"UTF-8");
						data = sender +" : "+data;
						for(Client c : ServerExample.clients) {
							// client 들에게 메세지 전달
							if(c != Client.this) {c.send(data);}
						}
					} catch (IOException e) {
						System.out.println("클라이언트 통신 안됨 "+socket.getRemoteSocketAddress());
						ServerExample.clients.remove(Client.this);
						try {
							if(is != null ) is.close();
							if(!socket.isClosed()) socket.close();
						} catch (IOException e1) {}
						break;
					} // end catch
				} // end while()
			}
		});
		t.start();
	} // end receive()
}








package server_chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {
	
	@FXML private TextArea displayText;
	@FXML private Button btnStartStop;
	
	//Client Thread를 관리할 스레드 풀
	ExecutorService serverPool;
	//운영체제에서 포트를 할당받아 client socket 연결 관리를 할 ServerSocket
	ServerSocket server;
	// Client 사용자 정보를 저장할 map
	// <사용자 닉네임, Client Socket 출력 스트림>
	Hashtable<String,PrintWriter> ht;
	
	// 사용할 포트 번호
	public final int SERVER_PORT = 5001;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStartStop.setOnAction(e->{
			if(btnStartStop.getText().equals("START")) {
				//서버시작
				startServer();
			}else {
				//서버 종료
				stopServer();
			}
		});
	}
	//서버시작
	public void startServer() {
		serverPool = Executors.newFixedThreadPool(50); // 최대 50개 까지 스레드를 생성해서 관리하겠다 (스레스풀 생성)
		ht = new Hashtable<>();//사용자 정보를 저장할 해시테이블
		try {
			server = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			displayText("서버 연결 오류"+ e.getMessage());
			stopServer();
			return;
		}
		//스레드 풀에 작업만 전달해주면 된다
		Runnable runnable =new Runnable() {
			@Override
			public void run() {
				Platform.runLater(()->{
					btnStartStop.setText("STOP"); // 일단 버튼을 STOP로 변경
				});
				displayText("[서버시작]");
				while (true) {
					try {//연결 요청 계속 보내는것임
						
						Socket client = server.accept();
						String address = client.getRemoteSocketAddress().toString();
						//엑셉트된 클라이언트의 연결정보를 address로 가져옴
						String message = "[연결 수락 : "+address+" ]";
						//클라이언트가 연결될때마다 스레드풀에 작업이 전달됨 ?
						serverPool.submit(new ServerTask(client, ht,ServerController.this));
						displayText(message);
					} catch (IOException e) {
						//오류가 발생하는건 클라이언트를 더이상 못받는다는것
						stopServer();
						break;
					}
				}
			}
		};
		serverPool.submit(runnable); //서버풀에 작업요청을 보냄 그럼 스레드를 생성해서 동작해줄것임
	}
	//서버종료
	public void stopServer() {
		if(ht != null) {// 이거 왜 ? 
			for(PrintWriter p : ht.values()) {
				if(p != null) {
					p.close();
				}
			}
		}
		if(server != null && !server.isClosed()) {
			try {
				server.close(); // 외부자원과 연결이 끊길수도있으니 예외처리
			} catch (IOException e) {}
		}
		if(serverPool != null && !serverPool.isShutdown()) {
			serverPool.shutdownNow(); // 서버풀이 동작중이면 강제종료 ! 
		}
		displayText("[ 서버 중지 ]");
		btnStartStop.setText("START");
	}
	public void displayText(String text) {
		Platform.runLater(()->{
			displayText.appendText(text+"\n");
		});
		
	}
}

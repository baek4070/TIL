package server_chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Server.fxml"));
		Parent root = loader.load();
		ServerController server = loader.getController();
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Chat Server");
		primaryStage.setResizable(false);
		//stop이 아닌 닫기버튼으로 종료하였을시 스레드가 계속 돌고있는걸 안전하게 종료시키겠다
		primaryStage.setOnCloseRequest(event->{
			server.stopServer();
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

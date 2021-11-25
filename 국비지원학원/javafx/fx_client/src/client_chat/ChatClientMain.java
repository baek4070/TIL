package client_chat;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatClientMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
			Parent root = loader.load();
			ClientController con = loader.getController();
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false);
			primaryStage.setOnCloseRequest(event->{
				con.stopClient();
			});
			primaryStage.setTitle("CHAT CLIENT");
			primaryStage.show();
		} catch (IOException e) {}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

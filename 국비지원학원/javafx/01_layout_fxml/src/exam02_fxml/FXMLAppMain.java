package exam02_fxml;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXMLAppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// 수평으로 자식 요소를 저장하는 Container
//		FXML 파일을 해석하여 Java객체로 생성하여 전달하는 Class
//		HBox root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("Sub.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

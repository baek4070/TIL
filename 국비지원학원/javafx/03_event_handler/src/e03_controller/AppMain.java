package e03_controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage s) {
		try {
			Parent root = FXMLLoader.load(
						getClass().getResource("Root.fxml")
					);
			Scene scene = new Scene(root);
			s.setScene(scene);
			s.show();
		} catch (IOException e) {}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

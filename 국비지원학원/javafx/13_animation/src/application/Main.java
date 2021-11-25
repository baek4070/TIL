package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
			
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("App Main");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

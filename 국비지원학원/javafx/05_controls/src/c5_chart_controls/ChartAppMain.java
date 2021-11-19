package c5_chart_controls;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChartAppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(
				getClass().getResource("Chart.fxml")
			);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}

package menu;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class RootController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void handleNew(ActionEvent event) {
		System.out.println("NEW");
	}
	
	public void handleOpen(ActionEvent event) {
		System.out.println("OPEN");
	}
	
	public void handleSave(ActionEvent event) {
		System.out.println("SAVE");
	}
	
}












package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootController implements Initializable {
	@FXML private Button btnLogin;
	@FXML private Button btnJoin;
	@FXML private Button btnCancel;
	@FXML private TextField txtId;
	@FXML private TextField txtPass;
	
	Stage dialog;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnJoin.setOnAction(event->{
			dialog = new Stage();
			dialog.setTitle("Join");
			try {
				Parent root = FXMLLoader.load(
						getClass().getResource("Join.fxml")
						);
				
				Scene scene = new Scene(root);
				dialog.setScene(scene);
				dialog.show();
			} catch (IOException e1) {}
		});
			
	}

}

//		btnLogin.setOnAction(event->{
//			String textId = txtId.getText().trim();
//			String textPass = txtPass.getText().trim();
//			System.out.println("id : "+textId);
//			System.out.println("pass : "+textPass);
//		});
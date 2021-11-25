package client_chat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController implements Initializable {
	@FXML private TextArea txtDisplay;
	@FXML private TextField txtIp, txtNick, txtInput;
	@FXML private ListView<String> listView;
	@FXML private Button btnConn, btnSend;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}

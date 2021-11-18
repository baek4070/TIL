package c1_button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ButtonController implements Initializable {
	@FXML private BorderPane root;
	@FXML private CheckBox chk1, chk2;
	@FXML private ToggleGroup group;
	@FXML private ImageView checkImageView, radioImageView;
	@FXML private Hyperlink hyperLink;
	@FXML private Button btnExit;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chk1.setOnAction(event->handlerChkAction(event));
		chk2.setOnAction(event->handlerChkAction(event));
		group.selectedToggleProperty()
		.addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton value = (RadioButton)newValue;
				String text = value.getText();
				System.out.println(text);
				text = "../images/images/"+text+".png";
				String path = getClass().getResource(text).toString();
				System.out.println(path);
				Image image = new Image(path);
				radioImageView.setImage(image);
			}
		}); // end radio group 속성 감시
		
		btnExit.setOnAction(event->{
			// UI thread 강제 종료
			Platform.exit();
		});
		
		hyperLink.setOnAction(event->{
			//hyperLink.setUserData(new Object());
			Object o = hyperLink.getUserData();
			String link = (String)o;
			// 도메인 정보를 가지고 웹 화면을 보여주는 view
			WebView webView = new WebView();
			WebEngine we = webView.getEngine();
			we.setJavaScriptEnabled(true);
			we.load(link);
			root.setTop(webView);
			
			Stage stage = new Stage();
			BorderPane pane = new BorderPane();
			pane.setCenter(webView);
			stage.setScene(new Scene(pane));
			stage.setWidth(1024);
			stage.setHeight(700);
			stage.show();
		});
	}
	public void handlerChkAction(ActionEvent event) {
		System.out.println(chk1.isSelected());
		System.out.println(chk2.isSelected());
		String resource ="";
		if(chk1.isSelected() && chk2.isSelected()) {
			resource = "../images/images/geek-glasses-hair.gif";
		}else if(chk1.isSelected()) {
			resource = "../images/images/geek-glasses.gif";
		}else if(chk2.isSelected()) {
			resource = "../images/images/geek-hair.gif";
		}else {
			resource = "../images/images/geek.gif";
		}
		checkImageView.setImage(new Image(getClass().getResource(resource).toString()));
	}
}

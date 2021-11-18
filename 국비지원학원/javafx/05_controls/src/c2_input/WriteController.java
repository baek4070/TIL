package c2_input;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class WriteController implements Initializable {
	
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPass;
	@FXML private ComboBox<String> comboPublic;
	@FXML private ColorPicker colorPicker;
	@FXML private DatePicker datePicker;
	@FXML private TextArea txtContent;
	@FXML private Button btnReg, btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnReg.setOnAction(event->{
			// TextField 에 작성된 문자열 가져오기
			String titleText = txtTitle.getText();
			System.out.println("제목 : " + titleText);
			String pass = txtPass.getText();
			System.out.println("Pass : " + pass);
			
			// ComboBox의 선택된 값을 가지고 옴 
			// 지정된 제네릭 타입으로 값을 반환
			// ComboBox<String> 문자열로 반환
			String comboData = comboPublic.getValue();
			System.out.println("combo data : " + comboData);
			
			// ColorPicker 선택된 색상 정보를 
			// Color 객체로 반환
			// Color : 색상에 대한 정보를 저장하는 객체 RGBA(Alpha or brightness)
			Color color = colorPicker.getValue();
			System.out.println("color : " + color);
			System.out.println("RED : " + color.getRed());
			System.out.println("Green : " + color.getGreen());
			System.out.println("BLUE : " + color.getBlue());
			System.out.println("Alpha : " + color.getBrightness());
			
			// 선택한 날짜의 정보를 LocaleDate type으로 반환
			// LocaleDate : 날짜 정보를 yyyy-MM-dd 형태로 저장하는 객체
			LocalDate date = datePicker.getValue();
			System.out.println(date);
			if(date != null) {
				System.out.println("연도 : "+date.getYear());
				System.out.println("월 : "+date.getMonth());
				System.out.println("월 : "+date.getMonthValue());
				System.out.println("일 : "+date.getDayOfMonth());
				System.out.println("날짜 : " + date.toString());
			}
			
			String content = txtContent.getText();
			System.out.println("content : " + content);
			
		});
		
		btnCancel.setOnAction(event->{
			txtTitle.setText("a");
			txtPass.setText("b");
			txtContent.setText("c");
			txtTitle.clear();
			ObservableList<String> list = comboPublic.getItems();
			list.add("항목추가");
			list.remove("공개");
			
			colorPicker.setValue(new Color(1,1,1,1));
			datePicker.setValue(null);
		}); // end btnCancel
		
		txtTitle.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
				if(event.getCode() == KeyCode.ENTER) {
					// button action event 실행
					btnReg.fire();
				}
			}
		});
		
		txtPass.textProperty()
		.addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
				txtContent.appendText(newValue+"\n");
			}
		});
	}
}









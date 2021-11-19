package c3_view_controls;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable {
	
	// 문자열 항목을 보여주는 listView
	@FXML private ListView<String> listView;
	@FXML private TableView<PhoneVO> tableView;
	@FXML private ImageView imageView;
	@FXML private Button btnAction, btnCancel;
	
	// 이름 수정 추가
	@FXML private TextField txtName;
	@FXML private Button btnUpdate;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list
			= FXCollections.observableArrayList(
				"갤럭시S1","갤럭시S2","갤럭시S3","갤럭시S4",
				"갤럭시S5","갤럭시S6","갤럭시S7"
			);
		
		/*
			= FXCollections.observableArrayList();
		list.add("갤럭시S1");
		*/
		listView.setItems(list);
		
		listView.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(
					ObservableValue<? extends Number> observable,
					Number oldValue, 
					Number newValue) {
				int index = newValue.intValue();
				System.out.println("listView 선택 index : " + index);
				System.out.println(list.get(index));
				tableView.getSelectionModel().select(index);
				//테이블 뷰의 scroll을 넘겨받은 인덱스 행으로 올림
				tableView.scrollTo(index);
			}
		}); // listView Listener
		
		// tableView 
		ObservableList<PhoneVO> phoneList
			= FXCollections.observableArrayList();
//		phoneList.add(new PhoneVO("갤럭시S1","phone01.png"));
//		phoneList.add(new PhoneVO("갤럭시S2","phone02.png"));
		for(int i=1; i<=7; i++) {
			phoneList.add(new PhoneVO("갤럭시S"+i,"phone0"+i+".png"));
		}
		/*
		TableColumn<PhoneVO,?> tColumn 
						= tableView.getColumns().get(0);
		tColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		tableView.getColumns().get(1)
		.setCellValueFactory(new PropertyValueFactory<>("path"));
		System.out.println(phoneList);
		*/
		// java.lang.reflect.*
		Field[] fields = PhoneVO.class.getFields();
		fields = PhoneVO.class.getDeclaredFields();
		System.out.println(fields.length);
		for(int i=0; i<fields.length; i++) {
			String fieldName = fields[i].getName();
			System.out.println(i+" , fieldName : " + fieldName);
			tableView.getColumns().get(i).setCellValueFactory(
				new PropertyValueFactory<>(fieldName)
			);
		}
		
		tableView.setItems(phoneList);
		
		// tableView 항목 변경 감지 Listener 추가
		tableView.getSelectionModel().selectedItemProperty()
		.addListener(new ChangeListener<PhoneVO>() {
			@Override
			public void changed(
					ObservableValue<? extends PhoneVO> observable,
					PhoneVO oldValue, 
					PhoneVO newValue) {
				if(newValue != null) {
					System.out.println(newValue);
					String path = "../images/"+newValue.getPath();
					URL url = getClass().getResource(path); 
					System.out.println(url.toString()); // file:// 
					System.out.println(url.getPath()); // 실제 경로
					imageView.setImage(new Image(url.toString()));
					
					// 수정을 위해 TextField에 기존 이름 정보 추가
					txtName.setText(newValue.getName());
				}
			}
		}); // end tableView item Listener
		
		tableView.getSelectionModel().selectedIndexProperty()
		.addListener((target,oldValue,newValue)->{
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					int index = newValue.intValue();
					// 해당 인덱스의 값이 사용자에 의해 선택되어진 것처럼 이벤트 처리
					listView.getSelectionModel().select(index);
					// 해당 index의 정보를 listView 상단으로 이동시킴 - 스크롤 이동
					listView.scrollTo(index);
				}
			});
		});
		
		// PhoneVO name field값 수정 - tableView 수정
		btnUpdate.setOnAction(event->{
			String name = txtName.getText();
			PhoneVO phone
			= tableView.getSelectionModel().getSelectedItem();
			System.out.println(phone);
			int index 
			= tableView.getSelectionModel().getSelectedIndex();
			list.set(index, name);
			System.out.println(list);
			
			if(phone != null) {
				phone.setName(name);
			}
			System.out.println(phoneList);
			tableView.refresh();
			listView.refresh();
		});
		
		
	}

}







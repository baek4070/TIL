package main;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RootController implements Initializable {
	@FXML private TableView<StudentVO> tableView;
	@FXML private Button btnAdd, btnGraph;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<StudentVO> studentList
		= FXCollections.observableArrayList();
		studentList.add(new StudentVO("홍길동A",40,60,80));
		studentList.add(new StudentVO("홍길동B",60,80,40));
		studentList.add(new StudentVO("홍길동C",80,40,60));
		
		Field[] fields = StudentVO.class.getFields();
		fields = StudentVO.class.getDeclaredFields();
		System.out.println(fields.length);
		for(int i=0; i<fields.length; i++) {
			String fieldName = fields[i].getName();
			System.out.println(i+" , fieldName : " + fieldName);
			tableView.getColumns().get(i).setCellValueFactory(
				new PropertyValueFactory<>(fieldName)
			);
		}
		
		tableView.setItems(studentList);

		tableView.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(
					ObservableValue<? extends Number> observable,
					Number oldValue, 
					Number newValue) {
				int index = newValue.intValue();
				System.out.println("tableView 선택 index : " + index);
				System.out.println(studentList.get(index));
				Stage stage = new Stage();
				Parent root = null;
				try {
					root=FXMLLoader.load(getClass().getResource("Second.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				stage.setScene(new Scene(root));
				stage.show();
			}
		});
		
	}

}

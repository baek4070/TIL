package c5_chart_controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable {

	@FXML private PieChart pieChart;
	@FXML private BarChart<String,Integer> barChart;
	@FXML private AreaChart<String, Integer> areaChart;
	@FXML private BubbleChart<Integer,Integer> bubbleChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// list == PieChart.Data 객체를 저장
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("AWT", 5),
				new PieChart.Data("Swing", 25),
				new PieChart.Data("SWT", 30),
				new PieChart.Data("JAVAFX", 60)
		));
		// BarChart
		XYChart.Series<String, Integer> series1 
				= new XYChart.Series<>();
		series1.setName("남자");
		
		XYChart.Series<String, Integer> series2 
				= new XYChart.Series<>();
		series2.setName("여자");
		
		ObservableList<XYChart.Data<String,Integer>> list
			= FXCollections.observableArrayList();
		list.add(new XYChart.Data<>("2018", 173));
		list.add(new XYChart.Data<>("2019", 173));
		list.add(new XYChart.Data<>("2020", 174));
		list.add(new XYChart.Data<>("2021", 175));
		series1.setData(list);
		
		list = FXCollections.observableArrayList();
		list.add(new XYChart.Data<>("2018",157));
		list.add(new XYChart.Data<>("2019",160));
		list.add(new XYChart.Data<>("2020",160));
		list.add(new XYChart.Data<>("2021",161));
		series2.setData(list);
		
		barChart.getData().add(series1);
		barChart.getData().add(series2);
		barChart.setTitle("평균 키");
		
		// AreaChart
		// 평균 온도
		areaChart.setTitle("평균온도");
		XYChart.Series<String, Integer> series3 
							= new XYChart.Series<>();
		series3.setName("서울");
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data<String,Integer>("2015",22),
				new XYChart.Data<String,Integer>("2016",23),
				new XYChart.Data<String,Integer>("2017",23),
				new XYChart.Data<String,Integer>("2018",24),
				new XYChart.Data<String,Integer>("2019",24),
				new XYChart.Data<String,Integer>("2020",23)
				));
		areaChart.getData().add(series3);
		
		XYChart.Series<String, Integer> series4 
		= new XYChart.Series<>();
		series4.setName("부산");
		series4.setData(FXCollections.observableArrayList(
				new XYChart.Data("2015",23),
				new XYChart.Data("2016",25),
				new XYChart.Data("2017",24),
				new XYChart.Data("2018",25),
				new XYChart.Data("2019",26),
				new XYChart.Data("2020",26)
			));
		areaChart.getData().add(series4);
		
		// BubbleChart
		// 체류 시간 별 상품 구매 수
		XYChart.Series<Integer, Integer> seriesA
								= new XYChart.Series<>();
		seriesA.setName("40대");
		//                                       분  금액   상품구매수
		//                                       x  y   scale                                          
		seriesA.getData().add(new XYChart.Data<>(5,  0,  0));
		seriesA.getData().add(new XYChart.Data<>(10, 1,  5));
		seriesA.getData().add(new XYChart.Data<>(20, 3,  7));
		seriesA.getData().add(new XYChart.Data<>(30, 5,  1));
		bubbleChart.getData().add(seriesA);
	}

}













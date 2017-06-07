package com.example.FXMLExample;

import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
	@FXML
	public TabPane tabPane;
	public AnchorPane tab3;
	@FXML
	public MenuItem exit;
	public AnchorPane tab1;
	public AnchorPane tab2;
	private ListView listView;
	private BarChart barChart;
	private TableView tableView;
	private ObservableList<Student> students = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (Node n : tab1.getChildren()) {
			if (n.getId().equals("tableView")) {
				tableView = (TableView) n;
				break;
			}
		}

		for (Node n : tab2.getChildren()) {
			if (n.getId().equals("listView")) {
				listView = (ListView) n;
				break;
			}
		}

		for (Node n : tab3.getChildren()) {
			if (n.getId().equals("histogram")) {
				barChart = (BarChart) n;
				break;
			}
		}

		exit.setAccelerator(KeyCharacterCombination.keyCombination("Ctrl+C"));

		tableView.setItems(students);
		listView.setItems(students);
	}


	public void addStudent(Student student) {
		students.add(student);

		barChart.setData(getChartData());
	}

	@SuppressWarnings({"ArrayCreationWithoutNewKeyword", "Duplicates"})
	private ObservableList<XYChart.Series<String, Double>> getChartData() {
		final int[] marksCount = {0, 0, 0, 0, 0, 0};
		String[] xAxisLabels = {"2.0", "3.0", "3.5", "4.0", "4.5", "5.0"};

		for (Student s : students)
		{
			if(s.getMark()==2.0)
			{marksCount[0]++;}//System.out.println("2.0++");}
			if(s.getMark()==3.0)
			{marksCount[1]++;}//System.out.println("3.0++");}
			if(s.getMark()==3.5)
			{marksCount[2]++;}//System.out.println("3.5++");}
			if(s.getMark()==4.0)
			{marksCount[3]++;}//System.out.println("4.0++");}
			if(s.getMark()==4.5)
			{marksCount[4]++;}//System.out.println("4.5++");}
			if(s.getMark()==5.0)
			{marksCount[5]++;}//System.out.println("5.0++");}
		}

		final ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
		final XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
		series.setName("Marks");

		for (int i = 0; i < marksCount.length; i++) {
			series.getData().add(new XYChart.Data(xAxisLabels[i], marksCount[i]));
		}

		answer.addAll(series);
		return answer;
	}

	public void close(ActionEvent actionEvent) {
		System.exit(0);
	}

	public void about(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("Example program information");
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	}
}

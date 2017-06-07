package com.example.FXMLExample;

import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by robert on 11.04.2017.
 */
public class StudentsController implements Initializable{


    @FXML
    public TableView tableView;
    ObservableList<Student> localStudents = FXCollections.observableArrayList();
    @FXML
    private TableColumn markColumn;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn ageColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        markColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("mark"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("age"));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

}

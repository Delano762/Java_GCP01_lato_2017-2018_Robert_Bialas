package com.example.CustomClasses;


import com.example.Student;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by robert on 29.03.2017.
 */
public class CustomTableView extends TableView {
    public  CustomTableView()
    {
        TableColumn Mark=new TableColumn("Mark");
        TableColumn FirstName=new TableColumn("First Name");
        TableColumn LastName=new TableColumn("Last Name");
        TableColumn Age=new TableColumn("Age");
        Mark.setCellValueFactory(new PropertyValueFactory<Student, String>("Mark"));
        FirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<Student, String>("LastName"));
        Age.setCellValueFactory(new PropertyValueFactory<Student, String>("Age"));
        getColumns().addAll(Mark,FirstName,LastName,Age);
    }
}

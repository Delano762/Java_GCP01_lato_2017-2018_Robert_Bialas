package com.example.Tabs;

import com.example.CustomClasses.CustomTableView;
import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by robert on 01.04.2017.
 */
public class StudentsTab extends Tab{
    private final CustomTableView tableView;
    //private final TableColumn Mark;
    //private final TableColumn FirstName;
    //private final TableColumn LastName;
    //private final TableColumn Age;
    private ObservableList<Student> students;

    public StudentsTab()
    {
        students = FXCollections.observableArrayList();
        this.setText("Students");
        this.setClosable(false);

        tableView = new CustomTableView();

        tableView.setColumnResizePolicy(CustomTableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setItems(students);



        //Mark=new TableColumn("Mark");
        //FirstName=new TableColumn("First Name");
        //LastName=new TableColumn("Last Name");
        //Age=new TableColumn("Age");


        this.setContent(this.tableView);
    }
    public void setData(CopyOnWriteArrayList<Student> StudentsToSet)
    {
        students = FXCollections.observableArrayList(StudentsToSet);
        this.tableView.setItems(students);
    }
}

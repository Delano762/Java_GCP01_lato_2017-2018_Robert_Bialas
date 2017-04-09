package com.example.Tabs;

import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by robert on 01.04.2017.
 */
public class LogTab extends Tab{
    private final ListView<String> listView;
    private final ObservableList<String> data;
    public LogTab()
    {
        this.listView = new ListView<>();
        this.data = FXCollections.observableArrayList();
        this.listView.setItems(data);

        this.setContent(this.listView);

        this.setText("Log");
        this.setClosable(false);
    }
    public void addData(String status, Student student) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        data.add(simpleDateFormat.format(date) + "        [" + status + "]          " +student.getFirstName() + "        " + student.getLastName());
    }
}

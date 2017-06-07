package com.example.FXMLExample;

import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by robert on 11.04.2017.
 */
public class LogController implements Initializable {
    @FXML
    public ListView listView;


    private ObservableList<String> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList();
        listView.setItems(data);

    }

    public synchronized void addData(String status, Student student) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        data.add(simpleDateFormat.format(date) + "        [" + status + "]          " +
                student.getFirstName() + "        " + student.getLastName());
    }
}

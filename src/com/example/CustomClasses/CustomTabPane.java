package com.example.CustomClasses;

import com.example.Tabs.HistogramTab;
import com.example.Tabs.LogTab;
import com.example.Tabs.StudentsTab;
import com.example.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TabPane;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by robert on 29.03.2017.
 */
public class CustomTabPane extends TabPane {
    private final CopyOnWriteArrayList<Student> studentsListCopy = new CopyOnWriteArrayList<>();
    final HistogramTab histogramTab;
    final StudentsTab studentsTab;
    private final LogTab logTab = new LogTab();
    public CustomTabPane()
    {
        histogramTab=new HistogramTab();
        studentsTab=new StudentsTab();
        //logTab=new LogTab();
        CustomTableView table = new CustomTableView();

        //bieda=0;
        this.getTabs().addAll(studentsTab, logTab, histogramTab);
    }
    public LogTab getLogTab()
    {
        return logTab;
    }
    public HistogramTab getHistogram()
    {
        return histogramTab;
    }
    public void addStudent(Student student)
    {
        studentsListCopy.add(student);
        histogramTab.setData(getChartData());
        studentsTab.setData(studentsListCopy);
    }
    public void removeStudent(Student student) {
        studentsListCopy.remove(student);

        histogramTab.setData(getChartData());
    }
    private ObservableList<XYChart.Series<String, Double>> getChartData() {

        String[] xAxisLabels = {"2.0", "3.0", "3.5", "4.0", "4.5", "5.0"};
        int[] marksCount = {0, 0, 0, 0, 0, 0};
        int bieda=0;
        for (Student s : studentsListCopy)
        {
            if(s.getMark()==2.0)
            {marksCount[0]++;System.out.println("2.0++");bieda++;System.out.println(bieda);}
            if(s.getMark()==3.0)
            {marksCount[1]++;System.out.println("3.0++");}
            if(s.getMark()==3.5)
            {marksCount[2]++;System.out.println("3.5++");}
            if(s.getMark()==4.0)
            {marksCount[3]++;System.out.println("4.0++");}
            if(s.getMark()==4.5)
            {marksCount[4]++;System.out.println("4.5++");}
            if(s.getMark()==5.0)
            {marksCount[5]++;System.out.println("5.0++");}
        }
        System.out.println("elo");
        System.out.println(bieda);
        final ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        final XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
        series.setName("Marks");
        //double bieda=2.0;
        for (int i = 0; i < marksCount.length; i++) {
            series.getData().add(new XYChart.Data(xAxisLabels[i], 3));
        }
        answer.addAll(series);


        return answer;
    }


}

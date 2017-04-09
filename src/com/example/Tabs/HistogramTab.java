package com.example.Tabs;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import javafx.geometry.Pos;

import javafx.scene.chart.XYChart;
import javafx.collections.ObservableList;
/**
 * Created by robert on 01.04.2017.
 */
public class HistogramTab extends Tab{
    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final BarChart chart = new BarChart(xAxis, yAxis);
    private final Label label = new Label("Distribution of marks");

    public HistogramTab()
    {
        //super();

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(label);
        vBox.getChildren().add(chart);

        this.xAxis.setLabel("Mark");
        this.yAxis.setLabel("Count");


        this.setText("Histogram");
        this.setClosable(false);
        this.yAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object.intValue());
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });
        this.setContent(vBox);
    }
    public void setData(ObservableList<XYChart.Series<String,Double>> observableList)
    {
        this.chart.setData(observableList);
    }
}

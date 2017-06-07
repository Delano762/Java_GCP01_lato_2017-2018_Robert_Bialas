package com.example.FXMLExample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by robert on 11.04.2017.
 */
public class HistogramController implements Initializable {
    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final Label label = new Label("Distribution of marks");
    @FXML
    public BarChart<String, Double> histogram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        xAxis.setLabel("Mark");
        yAxis.setLabel("Count");
        yAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object.intValue());
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });

        ((ValueAxis<Double>) histogram.getYAxis()).setTickLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return String.valueOf(object.intValue());
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
    }
}

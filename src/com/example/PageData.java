package com.example;

import javafx.scene.image.Image;

/**
 * Created by robert on 29.03.2017.
 */
public class PageData {
    public String name;
    public String description;
    public String binNames;
    public Image image;
    public PageData(String name, String description, String binNames) {
        this.name = name;
        this.description = description;
        this.binNames = binNames;
        //image = new Image(getClass().getResourceAsStream(name + ".jpg"));
    }
}
package com.example.CrawlerPackage;

/**
 * Created by robert on 28.03.2017.
 */
public class CrawlerException extends Exception {
    private String msg;

    public CrawlerException(String msg){
        super(msg);
    }
}

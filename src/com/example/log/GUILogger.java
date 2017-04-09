package com.example.log;

import com.example.Tabs.LogTab;
import com.example.Student;

/**
 * Created by robert on 29.03.2017.
 */
public class GUILogger implements Logger {
    private final LogTab logTab;
    public GUILogger(LogTab logTab)
    {
        this.logTab = logTab;
    }
    @Override
    public void log(String status,Student student)
    {
        logTab.addData(status,student);
    }
}

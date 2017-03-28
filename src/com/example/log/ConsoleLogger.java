package com.example.log;

import sun.rmi.runtime.Log;
import com.example.Student;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.rmi.StubNotFoundException;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.MessagingException;

/**
 * Created by robert on 28.03.2017.
 */
public class ConsoleLogger implements Logger{
public  ConsoleLogger(){}
    @Override
            public void log(String status,Student student){
        if(student==null)System.out.println(status);
        else System.out.println(status+":"+student.toString());
    }

}

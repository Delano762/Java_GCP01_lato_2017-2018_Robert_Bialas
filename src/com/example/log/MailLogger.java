package com.example.log;

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
public class MailLogger implements Logger{
private final String userName;
private final String password;
private final String recipient;
public MailLogger(String userName,String password,String recipient)
{
    this.userName=userName;
    this.password=password;
    this.recipient=recipient;
}

@Override
public void log(String status, Student student)
{
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "poczta.agh.edu.pl");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.port", "465");
    Session session = Session.getDefaultInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName,password);
        }
    });
    try{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        message.setSubject(status);

        message.setText("");
        if(student!=null){
            message.setText(student.toString());
        }
        Transport.send(message);
    }
    catch (MessagingException e)
    {
        e.printStackTrace();
        System.out.println("MailLogger Error");
    }
}
}

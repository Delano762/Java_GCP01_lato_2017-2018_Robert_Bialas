package com.example;

import com.example.log.ConsoleLogger;
import com.example.log.Logger;
import com.example.log.MailLogger;
import javafx.application.Application;

import java.net.URL;
public class Main extends Application{

    public static void main(String[] args) throws Exception{
        final Logger[] loggers = {new ConsoleLogger(),new MailLogger(args[1],args[2],args[3])};

        new Thread(()->{
            try{
                final Crawler crawler = new Crawler(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt"),args[0]);
                crawler.addIterationStartedListener((crawlerEvent -> System.out.println("Iteration"+crawlerEvent.getIteration())));
                crawler.addStudentAddedListener((crawlerEvent -> {
                    for(Logger logger : loggers){
                        logger.log("Added: "+crawlerEvent.getStudent().getFirstName()+" " + crawlerEvent.getStudent().getLastName(),crawlerEvent.getStudent());
                    }
                }));
                crawler.addIterationFinishedListeners(new CrawlerListener() {
                    @Override
                    public void actionPerformed(CrawlerEvent crawlerEvent) {

                    }
                });
                crawler.addStudentNoChangeListener((crawlerEvent -> System.out.println(crawlerEvent.getStudent().toString()+ ":"+crawlerEvent.getType())));
                crawler.run();
            }catch (Exception e){
                e.printStackTrace();;
                System.out.println("Error");
            }
        }).start();
    }
}

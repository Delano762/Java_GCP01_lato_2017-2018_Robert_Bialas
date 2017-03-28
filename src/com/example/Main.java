package com.example;

import com.example.log.ConsoleLogger;
import com.example.log.Logger;
import com.example.log.MailLogger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
public class Main extends Application{
    static String arguments[];
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                final Logger[] loggers = {new ConsoleLogger(),new MailLogger(arguments[1],arguments[2],arguments[3])};

                new Thread(()->{
                    try{
                        final Crawler crawler = new Crawler(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt"),arguments[0]);
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
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) throws Exception{

        arguments=args;
        launch(args);
    }
}

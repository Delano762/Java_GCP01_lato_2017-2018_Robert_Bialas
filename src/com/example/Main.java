package com.example;

import com.example.CustomClasses.CustomMenuBar;
import com.example.CustomClasses.CustomTabPane;
import com.example.log.GUILogger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

//import com.example.log.GUILogger;


public class Main extends Application {


    static String arguments[];

    public static void main(String[] args) throws Exception {

        arguments = args;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Sample");
        Scene scene = new Scene(new VBox(), 400, 350);
        scene.setFill(Color.OLDLACE);

        CustomMenuBar menuBar = new CustomMenuBar();

        CustomTabPane tabPane = new CustomTabPane();

        ((VBox) scene.getRoot()).setVgrow(tabPane, Priority.ALWAYS);
        //Adding menuBar to the scene
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, tabPane);
        primaryStage.setTitle("Crawler!");
        primaryStage.setScene(scene);
        primaryStage.show();
        GUILogger guiLogger = new GUILogger(tabPane.getLogTab());

        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                System.out.println("Hello World!");
            }
        });*/

        //VBox root = new VBox();
        //((VBox) scene.getRoot()).getChildren().add(btn);
        //final Logger[] loggers = {new ConsoleLogger()};//,new MailLogger(arguments[1],arguments[2],arguments[3])};
            try {
                final Crawler crawler = new Crawler(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt"), arguments[0]);
                //crawler.addIterationStartedListener((crawlerEvent -> System.out.println("Iteration" + crawlerEvent.getIteration())));
                crawler.addStudentAddedListener(new CrawlerListener() {
                    @Override
                    public void actionPerformed(CrawlerEvent crawlerEvent) {
                        tabPane.addStudent(crawlerEvent.getStudent());
                        guiLogger.log(crawlerEvent.getType().toString(), crawlerEvent.getStudent());
                    }
                });
                //for(Logger logger : loggers){
                //logger.log("Added: "+crawlerEvent.getStudent().getFirstName()+" " + crawlerEvent.getStudent().getLastName(),crawlerEvent.getStudent());
                //}

                crawler.addStudentRemovedListener(new CrawlerListener() {
                    @Override
                    public void actionPerformed(CrawlerEvent crawlerEvent) {
                        tabPane.removeStudent(crawlerEvent.getStudent());
                        guiLogger.log(crawlerEvent.getType().toString(), crawlerEvent.getStudent());
                    }
                });
                //crawler.addStudentNoChangeListener((crawlerEvent -> System.out.println(crawlerEvent.getStudent().toString() + ":" + crawlerEvent.getType())));
                crawler.run();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }





    }

}

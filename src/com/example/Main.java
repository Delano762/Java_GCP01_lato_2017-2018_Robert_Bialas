package com.example;

import com.example.CrawlerPackage.Crawler;
import com.example.CrawlerPackage.CrawlerEvent;
import com.example.CrawlerPackage.CrawlerListener;
import com.example.FXMLExample.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.Optional;

//import com.example.log.GUILogger;


public class Main extends Application {


    static String arguments[];
    //private MainController controller;
    public static void main(String[] args) throws Exception {

        arguments = args;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        //FXMLLoader loader = new FXMLLoader( Program.class.getResource("FXMLExample/main.fxml") );
        //FXMLLoader loader = new FXMLLoader( Main.class.getResource("FXMLExample/main.fxml") );


        //try
        //{

        //}
        //catch ( IOException e )
        //{
            //e.printStackTrace();

            //return;
        //}
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/Main.fxml"));
        //Parent root = loader.load();



        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

// Set the icon (must be included in the project).
        //dialog.setGraphic(new ImageView(this.getClass().getResource().toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        //String user,pass;
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                //user=username.getText();
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        //String user,pass;
        final String[] user = new String[2];
        //Pair<String,String> a = new Pair<String,String>("rbialas","rbialas");
        result.ifPresent(usernamePassword -> {
            //if(a.equals(result)){
            //System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());}
            user[0]=usernamePassword.getKey();
            user[1]=usernamePassword.getKey();
            //System.out.println("Username=" + user[0] + ", Password=" + user[1]);
        });

        if(user[0].equals("rbialas") && user[1].equals("rbialas"))
        {
            //System.out.println("Username=" + user[0] + ", Password=" + user[1]);
            Parent root1 = FXMLLoader.load(getClass().getResource("FXMLExample/Login.fxml"));
            Scene scene1 = new Scene(root1, 300, 275);

            stage.setTitle("FXML Welcome");
            stage.setScene(scene1);
            stage.show();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLExample/main.fxml"));
            //Parent root = loader.load();
            //loader.load();
            Parent root = loader.load();
            //controller = (MainController) loader.getController();
            MainController controller = loader.getController();
            Scene scene = new Scene(root);

            //stage.setTitle("FXML Welcome");
            stage.setScene(scene);
            stage.show();
            stage.setMinHeight(320);
            stage.setMinWidth(320);
            //Scene scene = new Scene(new VBox(), 400, 350);
            scene.setFill(Color.OLDLACE);


            //CustomMenuBar menuBar = new CustomMenuBar();
            //CustomTabPane tabPane = new CustomTabPane();

//        ((VBox) scene.getRoot()).setVgrow(tabPane, Priority.ALWAYS);
            //Adding menuBar to the scene
            // ((VBox) scene.getRoot()).getChildren().addAll(menuBar, tabPane);
            //primaryStage.setTitle("Crawler!");
            //primaryStage.setScene(scene);
            //primaryStage.show();
            //GUILogger guiLogger = new GUILogger(tabPane.getLogTab());

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
                //final Crawler crawler = new Crawler(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt"), arguments[0]);
                //crawler.addIterationStartedListener((crawlerEvent -> System.out.println("Iteration" + crawlerEvent.getIteration())));
                //crawler.addStudentAddedListener(new CrawlerListener() {
                    //@Override
                    //public void actionPerformed(CrawlerEvent crawlerEvent) {
                        //controller.addStudent(crawlerEvent.getStudent());
                        //tabPane.addStudent(crawlerEvent.getStudent());
                        //guiLogger.log(crawlerEvent.getType().toString(), crawlerEvent.getStudent());
                    //}
                //});
                //for(Logger logger : loggers){
                //logger.log("Added: "+crawlerEvent.getStudent().getFirstName()+" " + crawlerEvent.getStudent().getLastName(),crawlerEvent.getStudent());
                //}

                //crawler.addStudentRemovedListener(new CrawlerListener() {
                    //@Override
                    //public void actionPerformed(CrawlerEvent crawlerEvent) {
                        //tabPane.removeStudent(crawlerEvent.getStudent());
                        //guiLogger.log(crawlerEvent.getType().toString(), crawlerEvent.getStudent());
                    //}
                //});
                //crawler.addStudentNoChangeListener((crawlerEvent -> System.out.println(crawlerEvent.getStudent().toString() + ":" + crawlerEvent.getType())));
                //crawler.run();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }
        }




    }

}
//<Label fx:id="text" layoutX="0.0" layoutY="0.0" text="Control:Test" />
//<fx:include fx:id="control" layoutX="50.0" layoutY="70.0" source="control.fxml" />
//<fx:include fx:id="control2" layoutX="50.0" layoutY="90.0" source="control.fxml" text=".1..2..3." />
//<Button alignment="BASELINE_CENTER" layoutX="68.0" layoutY="161.0" onAction="#click" text="Click me!" />
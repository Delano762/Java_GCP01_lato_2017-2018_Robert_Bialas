package com.example.FXMLExample;
import java.io.IOException;

//import com.example.FXMLExample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program extends Application
{
	@Override
	public void start( Stage primaryStage )
	{
		FXMLLoader loader = new FXMLLoader( Program.class.getResource("FXMLExample/main.fxml") );
		
		try
		{
			loader.load();
		}
		catch ( IOException e )
		{
			e.printStackTrace();
			
			return;
		}
		
		Parent root = loader.getRoot();
		MainController controller = loader.getController();
		
		
		//controller.setText( "main()" );
		
		
		primaryStage.setScene( new Scene( root, 200, 200 ) );
		primaryStage.show();
	}
	
	public static void main( String[] args )
	{
		launch( args );
	}
}

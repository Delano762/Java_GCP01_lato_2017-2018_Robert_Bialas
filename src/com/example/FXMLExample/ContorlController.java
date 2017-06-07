package com.example.FXMLExample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContorlController
{
	@FXML
	private Label text;
	
	@FXML
	private void initialize()
	{
		this.text.setText( "Control:initialize()" );
	}

	public void setText( String text )
	{
		this.text.setText( "Control:" + text );
	}
}

package com.example.CustomClasses;

import com.example.Popup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCharacterCombination;


/**
 * Created by robert on 29.03.2017.
 */
public class CustomMenuBar extends MenuBar {
    public CustomMenuBar()
    {
        // Menu Program
        Menu menuProgram = new Menu("Program");
        // MenuItem ProgramClose and logic responsible for closing the program through it
        MenuItem ProgramClose = new MenuItem("Close");
        ProgramClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);// ProgramClose instruction
            }
        });
        ProgramClose.setAccelerator(KeyCharacterCombination.keyCombination("Ctrl+C"));// Sets CTRL + C as close shortcut
        menuProgram.getItems().add(ProgramClose); //Add ProgramClose to menuPrograM

        // Menu About
        Menu menuAbout = new Menu("About");
        MenuItem AboutAuthor = new MenuItem("Author");
        AboutAuthor.setOnAction(event ->
        {
            Popup.display();
        });
        menuAbout.getItems().addAll(AboutAuthor);
        //menuAbout.setGraphic();

        // Adding Program and About to menuBar
        getMenus().addAll(menuProgram, menuAbout);
    }
}

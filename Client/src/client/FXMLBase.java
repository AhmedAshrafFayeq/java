package client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class FXMLBase extends BorderPane {

    protected final TextArea textArea;
    protected final Button button;
    protected final TextField textField;

    public FXMLBase() {
        
     
        textArea = new TextArea();
        button = new Button();
        textField = new TextField();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(366.0);
        textArea.setPrefWidth(600.0);
        setTop(textArea);
        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(93.0);
        button.setText("Send");
        setRight(button);
        
        BorderPane.setAlignment(textField, javafx.geometry.Pos.CENTER);
        textField.setPrefHeight(44.0);
        textField.setPrefWidth(517.0);
        setLeft(textField);

    }
}

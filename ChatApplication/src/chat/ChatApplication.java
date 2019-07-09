/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class ChatApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextArea chatingArea=new TextArea("");
        TextField sendingField=new TextField();
        
        Button btn = new Button();
        btn.setText("Send");
        
        try{
            
            Socket clientSocket=new Socket("127.0.0.1",2020);
            Scanner scan =new Scanner(clientSocket.getInputStream());
            PrintStream streamToPrint =new PrintStream(clientSocket.getOutputStream());
            
            
            
            Thread readThread = new Thread(()->{
                while(true){
                    if(scan.hasNext())
                    {
                        String recieverdWord;
                        recieverdWord=scan.nextLine();
                        chatingArea.appendText(recieverdWord+"\n");
                    }
                }
                
            });
            
            readThread.start();
            
            btn.setOnAction(new EventHandler<ActionEvent>() {
                
                @Override
                public void handle(ActionEvent event) {
                    
                    streamToPrint.println(sendingField.getText());
                    sendingField.setText("");
                    
                }
            });
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
        FlowPane root = new FlowPane();
        root.getChildren().add(chatingArea);
        root.getChildren().add(sendingField);
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("My Chat App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

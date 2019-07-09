/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package client;

import common.ServerServices;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class Client extends Application {
    ClientServicesImplementation currentClient = null;
    FXMLBase root = null;
    ServerServices ref=null;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Registry register=LocateRegistry.getRegistry();
            ref=(ServerServices) register.lookup("ServerServices");
            ref.register(currentClient);
            root=new FXMLBase();
            Scene scene = new Scene(root, 600, 400);
            
            root.button.setOnAction(e->{
                String words=root.textField.getText();
                root.textField.setText("");
                try {
                    ref.broadcast(words);
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            });
            
            primaryStage.setTitle("Chat");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    
    
    @Override
    public void stop() throws Exception {
        ref.unregister(currentClient);
        System.exit(0);
        
        
    }

    public static void main(String[] args) {
        new Client();
        launch(args);
    }
    
    public Client()
    {
        
        try {
            Registry register=LocateRegistry.getRegistry("127.0.0.1");
            ServerServices  ServerInterfaceRefernce=(ServerServices) register.lookup("ServerServices");
            currentClient = new ClientServicesImplementation(this);
            
            //ServerInterfaceRefernce.register(clientInterfaceReference);
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

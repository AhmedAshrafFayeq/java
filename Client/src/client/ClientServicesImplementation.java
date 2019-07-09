/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.ClientServices;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ahmed
 */
public class ClientServicesImplementation extends UnicastRemoteObject implements ClientServices{
    
    Client GUI;
    
    public ClientServicesImplementation (Client gui)throws RemoteException
    {
        this.GUI=gui;
    }
    
    @Override
    public void recieve(String message) throws RemoteException {
        GUI.root.textArea.appendText(message+"\n");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ahmed
 */
public interface ClientServices extends Remote{
    void recieve(String message) throws  RemoteException;
}

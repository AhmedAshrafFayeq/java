/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ahmed
 */
public class Server {
    public static void main(String []args)
    {
        try{
            ServerSocket serverSocket=new ServerSocket(2020);
            Socket socket;
            while(true){
                socket=serverSocket.accept();
                new Thread(new ChatHandler(socket)).start();
                
            }
            
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}

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

/**
 *
 * @author ahmed
 */
public class Client {
    public static void main(String [] args)
    {
        try{
            
            Socket clientSocket=new Socket("127.0.0.1",2020);
            Scanner scan =new Scanner(clientSocket.getInputStream());
            Scanner scan1=new Scanner(System.in);
            PrintStream streamToPrint =new PrintStream(clientSocket.getOutputStream());
            
            Thread writeThread =new Thread(()->{
                String word;
                System.out.println("enter word");
                
                word=scan1.nextLine();
                streamToPrint.println(word);
            });
            Thread readThread = new Thread(()->{
                String recieverdWord;
                recieverdWord=scan.nextLine();
                System.out.println(recieverdWord);
            });
            writeThread.start();
            readThread.start();
            
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}

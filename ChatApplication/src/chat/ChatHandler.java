/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class ChatHandler implements Runnable {
    Socket chatHandlerSocket;
    static ArrayList<ChatHandler> listOfClients=new ArrayList<>();
    
    public ChatHandler(Socket socket) {
        chatHandlerSocket=socket;
        listOfClients.add(this);
    }
    
    Scanner scan;
    PrintStream streamToPrint;
    @Override
    public void run() {
        try{
            scan=new Scanner (chatHandlerSocket.getInputStream());
            streamToPrint =new PrintStream(chatHandlerSocket.getOutputStream());
            
            while(true)
            {
                if(scan.hasNext())
                {
                    String line=scan.nextLine();
                    listOfClients.forEach(m ->{
                        
                        PrintStream pw = null;
                        try {
                            pw = new PrintStream (m.chatHandlerSocket.getOutputStream());
                            pw.println(line);
                            
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    });
                }
            }
        }catch(IOException  e)
        {
            e.printStackTrace();
        }finally{
            try{
                chatHandlerSocket.close();
            }catch(IOException w)
            {
                w.printStackTrace();
            }
        }
    }
    
}

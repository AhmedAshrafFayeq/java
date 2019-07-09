/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package consoletextapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class ConsoleTextApplication {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String>listOfWords=new ArrayList<>();
        BufferedReader bfr=new BufferedReader(new InputStreamReader (System.in));
        String str=null;
        System.out.println("Enter your words");
        System.out.println(",,stop,, to exit");
        do{
            try{
                str=bfr.readLine();
                if(!str.equals("stop"))
                    listOfWords.add(str);
            }catch(IOException e)
            {
                System.out.println("error reading word");
            }
        }while(!str.equals("stop"));
        for(String s:listOfWords)
        {
            System.out.println(s);
        }
        
    }
    
}

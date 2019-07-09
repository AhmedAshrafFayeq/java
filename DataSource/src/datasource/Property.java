/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed
 */
public class Property {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Properties property=new Properties();
        OutputStream output=null;
        try {
            output=new FileOutputStream("db.properties");
            property.setProperty("MYSQL_DB_URL","jdbc:mysql://localhost:3333/employeedb");
            property.setProperty("MYSQL_DB_USERNAME","ashraf");
            property.setProperty("MYSQL_DB_PASSWORD","ay7aga@123");
            property.store(output, null);
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(output !=null)
            {
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
    }
    
}

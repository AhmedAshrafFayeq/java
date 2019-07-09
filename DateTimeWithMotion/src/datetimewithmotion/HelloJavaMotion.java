/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetimewithmotion;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class HelloJavaMotion extends JFrame implements Runnable{
    Thread th;
    JLabel label=new JLabel();
    int x=0;
    int y=0;
    HelloJavaMotion()
    {
        setTitle("Banner Application");
        setSize(500,500);
        setLayout(null);
        setBounds(400,150, 600, 400); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setText("Hello Java !");    
        this.add(label);
        th=new Thread(this);
        th.start();
    }
    
    @Override
    public void run() {
        while(true)
        {
            
            label.setBounds(x, y, 600, 400);
            x++;
            if (x>=this.getWidth())
            {
                x=0;
            }
           
           try {
               Thread.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(HelloJavaMotion.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        HelloJavaMotion d=new HelloJavaMotion();
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmed
 */
public class Ball extends JFrame implements Runnable{
    ImageIcon image=new ImageIcon(getClass().getResource("ball.png"));
    Thread th;
    JLabel label=new JLabel(image);
    Button pause=new Button("Pause");
    Button resume=new Button("Resume");
    
    int x,y=0;
    boolean xFlag,yFlag=true;
    volatile static boolean flag=true;
    Ball() 
    {
        setTitle("Bouncing Ball");
        
        
        setVisible(true);
        setBounds(400,150, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setBounds(200,200,100, 100);
        pause.setBounds(150, 310, 80, 30);
        resume.setBounds(300, 310, 80, 30);
        pause.setBackground(Color.RED);
        resume.setBackground(Color.GREEN);
        
        
        this.add(resume);
        this.add(pause);
        this.add(label);
        setLayout(null);
        th =new Thread(this);
        th.start();
        pause.addActionListener((e)->{
            flag=false;
        });
        resume.addActionListener((e)->{
            flag=true;
            
        });
    }
    
    @Override
    public void run() {
        while (true)
        
            if(flag){
                if((label.getBounds().x + label.getBounds().width)>=this.getWidth()-13)
                {
                    xFlag=false;
                }
                if(label.getBounds().x<=0){
                    xFlag=true;
                }
                if((label.getBounds().y + label.getBounds().height)>=this.getHeight()-30)
                {
                    yFlag=false;
                }
                if(label.getBounds().y<=0){
                    yFlag=true;
                }
                label.setBounds(xFlag?++x:--x,yFlag?++y:--y ,100, 100);

                try {
                   Thread.sleep(10);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            else{
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ball b=new Ball();
       
    }
 
}

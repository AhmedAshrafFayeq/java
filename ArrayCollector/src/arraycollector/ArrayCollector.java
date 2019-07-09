/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraycollector;

public class ArrayCollector {
    
    static int index=0;
    static int mixedArray[]=new int[15];
    
    public static void main(String[] args) {
        // TODO code application logic here
        int array1[]={1,2,3,4,5};
        int array2[]={10,20,30,40,50};
        int array3[]={100,200,300,400,500};
        
        
        
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                addElements(array1);
                
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                addElements(array2);
            }
        });
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                addElements(array3);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
        }catch(InterruptedException e)
        {
            System.out.println("error");
        }
        
        for(int i=0;i<mixedArray.length;i++)
            System.out.println(mixedArray[i]);
        
        
    }
    synchronized static void addElements(int array[])
    {
        for (int i=0;i<array.length;i++)
        {
            mixedArray[index++]=array[i];
            try{
                Thread.sleep(5);
            }catch(InterruptedException e)
            {
                System.out.println("error");
            }
        }
    }
    
}

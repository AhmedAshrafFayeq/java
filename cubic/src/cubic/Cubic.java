/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubic;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author ahmed
 */
public class Cubic {

    
    public static void main(String[] args) {
        ForkJoinPool FJP= new ForkJoinPool();
        double []numbers=new double [3000];
        for(int i =0;i<numbers.length;i++)
        {
            numbers[i]=i+1;
        }
        for (int i=0;i<15;i++)
        {
            System.out.println(numbers[i]);
        }
        System.out.println("--- After Cubic ---");
        CubicTransform task=new CubicTransform(numbers, 0, numbers.length);
        FJP.invoke(task);
        for(int i=0;i<15;i++)
        {
            System.out.println(numbers[i]);
        }
           
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 *
 * @author ahmed
 */
public class CubicTransform {
    public static void main(String [] args)
    {
        double []numbers=new double[3000];
        for(int i =0;i<numbers.length;i++)
        {
            numbers[i]=i+1;
        }
        for (int i=0;i<15;i++)
        {
            System.out.println(numbers[i]);
        }
        
        double[] cubicNumbers = DoubleStream.of(numbers).map(number->Math.pow(number,3.0)).parallel().toArray();
        for (int i=0;i<15;i++)
        {
            System.out.println(cubicNumbers[i]);
        }
        System.out.println("ParallelStram : The summition = "+DoubleStream.of(numbers).map(number->Math.pow(number,3.0)).sum());
        
    }
        
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitrator;

import static java.lang.Double.sum;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 *
 * @author ahmed
 */
public class CubicTrasnform {
    
    static double sum=0;
    public static void main(String [] args)
    {
        
        List<Double> listOfNumbers =new ArrayList<>();
        for(double i =1;i<=3000;i++)
        {
            listOfNumbers.add(i);
        }
        
        Spliterator<Double> spliter=listOfNumbers.spliterator();
        Spliterator<Double> spliter2=spliter.trySplit();
        
        List<Double> listOfCubicNumbers =new ArrayList<>();
        while(spliter2.tryAdvance((n)->listOfCubicNumbers.add(Math.pow(n,3.0))));
        while(spliter.tryAdvance((n)->listOfCubicNumbers.add(Math.pow(n,3.0))));
            
        listOfNumbers.stream().limit(15).forEach((n)->System.out.println(n));
        listOfCubicNumbers.stream().limit(15).forEach((n)->System.out.println(n));
        
        listOfCubicNumbers.forEach(number ->sum +=number);
        System.out.println("using Splitrator : sum = "+sum);
        
    }
}

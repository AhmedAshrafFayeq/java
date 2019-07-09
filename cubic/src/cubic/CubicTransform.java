/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubic;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author ahmed
 */
public class CubicTransform extends RecursiveAction{

    final int threshold =500;
    double []data;
    int start,end;

    public CubicTransform(double []data, int start, int end) {
        this.data=data;
        this.start=start;
        this.end=end;
    }


    @Override
    protected void compute() {
        if(end-start<threshold)
        {
            for(int i=start;i<end;i++)
            {
                data[i]=Math.pow(data[i],3.0);
            }
        }
        else{
            int middle=(end+start)/2;
            invokeAll(new CubicTransform(data,start,middle),new CubicTransform(data,middle,end));
        }
    }

}

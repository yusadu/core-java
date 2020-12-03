package edu.Math.nf.Result;

/**
 * 取余
 */
public class Surplus extends Calc{
    @Override
    public double Calc(double n1,double n2){
        double result=0;
        result=n1%n2;
        return result;
    }
}

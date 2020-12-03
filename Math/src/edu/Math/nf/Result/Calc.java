package edu.Math.nf.Result;

public abstract class Calc {
    /**
     * 运算方法
     * @param n1
     * @param n2
     * @return
     */
    public abstract double Calc(double n1,double n2);

    /**
     * 返回计算结果
     * @param n1
     * @param n2
     */
    public void Result(double n1,double n2){
        double Result=Calc(n1,n2);
        System.out.println("结果："+Result);
    }
}

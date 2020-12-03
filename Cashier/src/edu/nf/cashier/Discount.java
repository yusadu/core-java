package edu.nf.cashier;

/**
 * 折扣收费
 */
public class Discount extends Charge{
    //定义一个折扣率
    private double discount=1;

    public Discount(double discount){
        this.discount=discount;
    }

    @Override
    public double Charge(double money,Product product){
        System.out.println("收费方式：折扣收费");
        return money-product.getPrice()*discount;
    }
}

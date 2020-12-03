package edu.nf.cashier;

/**
 * 无优惠收费方式
 */
public class Normal extends Charge{

    
    @Override
    public double Charge(double money,Product product){
        System.out.println("收费方式：无优惠收费");
        return money-product.getPrice();
    }
}

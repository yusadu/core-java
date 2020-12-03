package edu.nf.cashier2;

import edu.nf.cashier.Product;

public abstract class Cashier2 {
    public abstract double Charge(ChargeParams params);

    /**
     * 找零
     */
    public void Cashier(ChargeParams params){
        System.out.println("商品："+params.getProduct().getName());
        System.out.println("价格："+params.getProduct().getPrice());
        System.out.println("实收："+params.getMoney());
        System.out.println("找零："+params.getGivechange()+"\n");
    }

}

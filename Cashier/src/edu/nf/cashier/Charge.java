package edu.nf.cashier;

public abstract class Charge {


    /**
     * 根据收费方式计算收费
     */
    public abstract double Charge(double money,Product product);

    /**
     * 找零
     */
    public void Cashier(Product product,double receipts,double Givechange){
        System.out.println("商品："+product.getName());
        System.out.println("价格："+product.getPrice());
        System.out.println("实收："+receipts);
        System.out.println("找零："+Givechange+"\n");
    }

}

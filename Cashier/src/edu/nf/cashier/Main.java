package edu.nf.cashier;

public class Main {
    public static void main(String[] args) {
        //实收金额
        double receipts=30000;
        //商品信息
        Product p=new Product();
        p.setName("五菱宏光");
        p.setPrice(29999);
        //折扣收费
        Charge c1=new Discount(0.5);
        double Givechange1=c1.Charge(receipts,p);
        c1.Cashier(p,receipts,Givechange1);
        //无优惠收费
        Charge c2=new Normal();
        double Givechange2=c2.Charge(receipts,p);
        c2.Cashier(p,receipts,Givechange2);
        //满减收费
        Charge c3=new Reduction(20000,200);
        double Givechange3=c3.Charge(receipts,p);
        c3.Cashier(p,receipts,Givechange3);
    }
}


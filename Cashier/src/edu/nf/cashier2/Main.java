package edu.nf.cashier2;

import edu.nf.cashier.Product;

public class Main {
    public static void main(String[] args) {
        Product p=new Product();
        p.setName("五菱宏光");
        p.setPrice(29999);
        ChargeParams params=new ChargeParams();
        params.setProduct(p);
        params.setMoney(30000.0);
        params.setDiscount(0.8);
        params.setMoneyCondition(10000.0);
        params.setMoneyReturn(200.0);

        //正常收费
        Cashier2 cashier1=new Normal();
        Double Givechange1=cashier1.Charge(params);
        params.setGivechange(Givechange1);
        cashier1.Cashier(params);

        //折扣收费
        Cashier2 cashier2=new Discount();
        Double Givechange2=cashier2.Charge(params);
        params.setGivechange(Givechange2);
        cashier2.Cashier(params);

        //返利收费
        Cashier2 cashier3=new Reduction();
        Double Givechange3=cashier3.Charge(params);
        params.setGivechange(Givechange3);
        cashier3.Cashier(params);
    }
}

package edu.nf.cashier;

/**
 * 满减收费
 */
public class Reduction extends Charge{
    private double type=0;
    private double discount=0;
    public Reduction(double type, double discount){
        this.type=type;
        this.discount=discount;
    }

    @Override
    public double Charge(double money, Product product) {
        System.out.println("收费方式：满减收费");
        if(product.getPrice()>=type){
            return money+discount-product.getPrice();
        }else{
            return money-product.getPrice();
        }
    }
}

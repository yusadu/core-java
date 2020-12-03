package edu.nf.cashier2;

public class Reduction extends Cashier2{
    @Override
    public double Charge(ChargeParams params) {
        double Givechange=params.getMoney()-params.getProduct().getPrice();
        if(params.getProduct().getPrice()>params.getMoneyCondition()){
            Givechange=params.getMoney()-params.getProduct().getPrice()+params.getMoneyReturn();
        }
        return Givechange;
    }
}

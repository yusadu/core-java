package edu.nf.cashier2;

import edu.nf.cashier.Charge;

public class Normal extends Cashier2{
    @Override
    public double Charge(ChargeParams params){
        double Givechange=params.getMoney()-params.getProduct().getPrice();
        return Givechange;
    }
}

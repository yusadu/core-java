package edu.nf.cashier2;

import edu.nf.cashier.Charge;

public class Discount extends Cashier2{
    @Override
    public double Charge(ChargeParams params) {
        return params.getMoney()-params.getProduct().getPrice()*params.getDiscount();
    }
}

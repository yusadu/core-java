package edu.nf.Interface;

import edu.nf.Interface.Product;

public class ChargeParams {
    //用户支付金额
    private Double money;
    //折扣率
    private Double discount;
    //满利条件
    private  Double moneyCondition;
    //返利金额
    private Double moneyReturn;
    //商品信息
    private Product product;
    //找零
    private Double Givechange;

    public Double getGivechange() {
        return Givechange;
    }

    public void setGivechange(Double givechange) {
        Givechange = givechange;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getMoneyCondition() {
        return moneyCondition;
    }

    public void setMoneyCondition(Double moneyCondition) {
        this.moneyCondition = moneyCondition;
    }

    public Double getMoneyReturn() {
        return moneyReturn;
    }

    public void setMoneyReturn(Double moneyReturn) {
        this.moneyReturn = moneyReturn;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

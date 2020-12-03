package edu.nf.Interface;

public interface Charge {
    /**
     * @author wangl
     * 接口中只能定义常量和抽象方法，
     * 一个类是可以同时定义多个接口，但是只能继承一个
     */
    public String CLASS_MAAM="";

    /**
     * 接口中定义
     * @param params
     * @return
     */
    public double charge(ChargeParams params);
}

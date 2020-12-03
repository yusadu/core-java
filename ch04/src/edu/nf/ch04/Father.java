package edu.nf.ch04;

/**
 * 对象的初始化流程
 * 初始化父类的静态成员--->子类的静态成员--->初始化父类的实例变量--->
 * 执行父类的实例代码块--->执行父类的构造方法--->初始化子类的实例变量--->
 * --->执行子类的实例代码块--->执行子类的构造方法
 */
public class Father {
    //实例变量（创建对象时初始化）
    private String fname="father";
    //静态变量（类加载时初始化）
    private static String birthplace="广东";

    //静态代码块（静态代码块也是在类加载时执行一次）
    //并且静态代码块只能访问其他的静态成员
    static {
        System.out.println(birthplace);
    }

    //实例代码块（每创建一次对象就执行一次）
    {
        System.out.println(fname);
    }

    public Father(){
        System.out.println("This is father");
    }
}

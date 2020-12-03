package edu.nf.ch04;

public class Son extends Father{
    private String sname="son";
    private static String sex="男";

    static {
        System.out.println(sex);
    }

    {
        System.out.println(sname);
    }

    public Son(){
        //任何构造方法的第一行代码都是一个隐式的super()，
        //表示调用父类的构造方法，
        //因为这样能正确的先初始化父类，一直到Object
//        super();
        System.out.println("This is Son");
    }

    public static void main(String[] args) {
        Son son=new Son();

    }
}

package edu.nf.ch02;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception{
        //多态（这种方法是写死的）
        //Teacher teacher=new JavaTeacher();

        //优化（运行时动态创建子类对象）
        String className=PropUtils.getProperty("name");
        System.out.println(className);
        //编译时看父类，也就是说在Teacher类中是否在say方法
        //运行时看子类，也就是程序在运行   起来的过程中是否有子类重写父类的方法
        //如果存在重写，那么运行的就是子类的say方法，如果没有重写，运行的就是父类的方法
        Teacher teacher=(Teacher)Class.forName(className).newInstance();
        teacher.say();
    }
}

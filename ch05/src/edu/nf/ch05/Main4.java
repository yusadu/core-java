package edu.nf.ch05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Main4 {

    public static void main(String[] args) throws Exception{
        //获取Users的Class对象
        Class<?> clazz=Class.forName("edu.nf.ch05.Users");
        //获取所有公共的构造方法，构造方法使用Constructor对象来描述，
        //一个Constructor表示一个构造方法
        Constructor[] constructors=clazz.getConstructors();

        for (Constructor c:constructors) {
            //获取构造方法名称
            System.out.println(c.getName());
            //获取构造方法的参数信息
            Parameter[] parameters=c.getParameters();
            //循环输出每一个参数的详细信息
            for (Parameter p:parameters
                 ) {
                System.out.println("参数名称："+p.getName());
                System.out.println("参数类型："+p.getType());
            }
            System.out.println();
        }
        System.out.println("-----------------");
        //获取某一个公共的构造方法
        Constructor constructor=clazz.getConstructor(String.class);
        //使用构造方法来创建实例,同时需要传入构造方法所需的参数
        //如果是无参的构造方法，则不需要
        Object object=constructor.newInstance("user1");
        System.out.println("创建出的实例："+object);

        System.out.println("------------------------");
        //获取所有的构造方法，包括私有的
        Constructor[] constructors2=clazz.getDeclaredConstructors();
        for (Constructor c:constructors2) {
            //获取构造方法名称
            System.out.println(c.getName()+",参数个数："+c.getParameterCount());
            //获取构造方法的参数信息
            Parameter[] parameters=c.getParameters();
            //循环输出每一个参数的详细信息
            for (Parameter p:parameters
            ) {
                System.out.println("参数名称："+p.getName());
                System.out.println("参数类型："+p.getType());
            }
            System.out.println();
        }

        //获取某一个私有的构造方法
        Constructor constructor2=clazz.getDeclaredConstructor(Integer.TYPE);
        System.out.println("私有构造方法："+ clazz.getName());

        //如果要使用使用的构造方法来创建实例，必须先打开访问开关
        constructor2.setAccessible(true);
        Object object2=constructor2.newInstance(1);
        System.out.println("私有构造方法创建的实例："+object2);

    }
}

package edu.nf.ch05;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main3 {
    public static void main(String[] args) throws Exception{
        //获取users类的Class对象
        Class<?> clazz=Users.class;
        //根据Class对象创建当前类的实例(会执行构造方法)
        Object obj=clazz.newInstance();

        //获取当前类的所有公共的方法，包括继承的(自然也包括OBJECT中的方法)
        //Method用于描述方法信息，一个方法使用一个Method来描述
        Method[] methods=clazz.getMethods();
        for (Method method:methods) {
            //获取方法名称
            System.out.println("名称："+method.getName());
            //获取方法的返回值类型
            System.out.println("返回类型："+method.getReturnType());
        }
        System.out.println("------------------------");

        //获取某一个公共的方法，参数指定方法名
        //第二个参数开始是一个可变参数，表示方法的参数类型
        //如果方法声明了参数，那么就需要指定参数类型
        Method method1=clazz.getMethod("say",String.class,Integer.TYPE);
        //获取方法名
        System.out.println(method1.getName());
        //获取方法返回类型
        System.out.println(method1.getReturnType());
        System.out.println("-------------------------------------");
        //获取方法参数个数
        System.out.println(method1.getParameterCount());
        //获取方法参数信息，Parameter表示参数信息，一个Parameter
        //表示一个参数对象
        Parameter[] parameters=method1.getParameters();
        for (Parameter parameter:parameters){
            //获取参数名称
            System.out.println(parameter.getName());
            //获取参数类型
            System.out.println(parameter.getType());
        }
        //调用当前方法，使用 invoke方法，参数一传入当前类的实例，第二个参数
        //开始是一个可变参数，表示参数的实参，如果方法有返回值，
        //那么invoke也会返回相应的值，如果方法返回值是void，那么invoke则返回null
        Object returnVal=method1.invoke(obj,"user2",21);
        System.out.println(returnVal);

        //获取某个私有的方法
        Method method2=clazz.getDeclaredMethod("run");
        //私有方法不能直接访问的，调用前也必须先打开访问开关
        method2.setAccessible(true);
        //run方法没有参数，因此调用invoke时不需要传入实参，只需传入当前类实例
        method2.invoke(obj);

        //获取本类中所有的方法，包括私有和公共的，但不包括继承的
        Method[] methods2=clazz.getDeclaredMethods();
        for (Method m:methods2) {
            System.out.println(m.getName());
        }
    }
}

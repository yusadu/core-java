package edu.nf.ch05;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws Exception{
        //获取Class对象
        Class clazz=Users.class;
        //通过Class对象创建当前类的实例
        Object obj=clazz.newInstance();
        //获取简单类名
        String className1=clazz.getSimpleName();
        System.out.println(className1);
        //获取完整类名（包含包名）
        String className2=clazz.getName();
        System.out.println(className2);
        //获取包名
        String packageName=clazz.getPackage().getName();
        System.out.println(packageName);
        System.out.println("---------------------");
        //获取所有公共字段（包括继承的公共字段）,Field封装Class中的字段信息,
        //一个字段就对应一个Field对象来描述
        Field[]fields=clazz.getFields();
        for(Field f:fields){
            //获取字段的名称
            System.out.println(f.getName());
            //获取字段的类型
            System.out.println(f.getType());
        }
        //获取某个公共字段
        Field field=clazz.getField("userName");
        System.out.println(field.getName()+":"+field.getType());
        //给字段赋值，set方法第一个参数是当前类的实例，第二个参数是要赋值的内容
        field.set(obj,"zhangsan");
        //取值
        String value=(String)field.get(obj);
        System.out.println(value);

        //根据字段名称获取私有的字段
        Field field2=clazz.getDeclaredField("address");
        //由于是私有的，因此不能直接进行访问操作，必须先打开访问开关
        field2.setAccessible(true);
        //给私有字段赋值和取值
        field2.set(obj,"zhuhai");
        System.out.println(field2.get(obj));

        //获取当前类所有的字段，包括私有和公共的，但不包括继承的
        Field[]fields2=clazz.getDeclaredFields();
        for (Field f:fields2) {
            System.out.println(f.getName());
        }
    }


}

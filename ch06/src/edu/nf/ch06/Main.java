package edu.nf.ch06;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args)  throws Exception{

        System.out.println("获取类上的注解信息");
        //获取Users的Class对象
        Class<?> clazz=Users.class;
        //获取类上标识的注解信息
        //isAnnotationPresent方法用于判断是否标识了注解
        //如果标识 则返回true
        if(clazz.isAnnotationPresent(MyAnno.class)){
            //获取注解
            MyAnno anno=clazz.getAnnotation(MyAnno.class);
            //获取所有的注解类
            Annotation[]annotations=clazz.getAnnotations();
            //获取注解的属性值
            String value=anno.value();
            String name=anno.name();
            System.out.println("name: "+name+" , value: "+value);
        }

        System.out.println("-------------------------------");
        System.out.println("获取方法上的注解信息");

        //获取Class对象中的say方法
        Method method=clazz.getMethod("say",String.class,Integer.TYPE);
        //判断say方法是否标识了MyAnno注解
        if(method.isAnnotationPresent(MyAnno.class)){
            //获取say方法上的MyAnno注解
            MyAnno methodAnno=method.getAnnotation(MyAnno.class);
            //获取say方法上的MyAnno注解的属性值
            String methodvalue=methodAnno.value();
            String methodname=methodAnno.name();
            System.out.println("name: "+methodname+" , value: "+methodvalue);
        }

        System.out.println("-------------------------------");
        System.out.println("获取字段上的参数信息");

        //获取Class对象上的字段的注解信息
        Field field=clazz.getDeclaredField("name");
        if (field.isAnnotationPresent(MyAnno.class)){
            MyAnno fieldAnno=field.getAnnotation(MyAnno.class);
            String fieldvalue=fieldAnno.value();
            String fieldname=fieldAnno.value();
            System.out.println("name: "+fieldname+" , value: "+fieldvalue);
        }

        System.out.println("-------------------------------");
        System.out.println("获取参数上的注解信息");

        //获取方法参数上的注解信息
        Parameter[] parameters=method.getParameters();
        for (Parameter p:parameters) {
            if(p.isAnnotationPresent(MyAnno.class)){
                MyAnno parameterAnno=p.getAnnotation(MyAnno.class);
                System.out.println("name: "+parameterAnno.name()+" , value: "+parameterAnno.value());
            }
        }

        System.out.println("-------------------------------");
        System.out.println("获取构造方法上的注解信息");

        //获取构造方法上的注解信息
        Constructor constructor=clazz.getConstructor(String.class);
        if(constructor.isAnnotationPresent(MyAnno.class)){
            MyAnno constructorAnno=(MyAnno) constructor.getAnnotation(MyAnno.class);
            System.out.println("name: "+constructorAnno.name()+" , value: "+constructorAnno.value());
        }
    }
}

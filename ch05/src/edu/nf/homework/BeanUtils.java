package edu.nf.homework;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {
    public static Object convert(Map<String,Object> map,Class<?> clazz) throws Exception{
        Object obj=clazz.newInstance();
        for(String key : map.keySet()){
            Field f = clazz.getDeclaredField(key);
            f.setAccessible(true);
            f.set(obj, map.get(key));
        }
        return  obj;
    }

    public static Map<String,Object>convertToMap(Object obj)throws Exception{
        //创建map集合
        Map<String,Object> map=new HashMap<>();
        //获取class对象
        Class clazz=obj.getClass();
        //根据class对象获取所有私有的字段
        Field[] fields=clazz.getDeclaredFields();
        //循环所有私有的字段
        for (Field field:fields) {
            //打开访问开关
            field.setAccessible(true);
            //获取当前私有字段的值
            Object value=field.get(obj);
            //将当前私有字段放入map集合
            map.put(field.getName(),value);
        }
        return map;
    }

    public static void copy(Object src,Object target) throws Exception{
        //获取class对象
        Class<?> srcClass=src.getClass();
        Class<?> targetClass=target.getClass();
        //根据class对象获取所有私有的字段
        Field[] fields=srcClass.getDeclaredFields();

        for (Field field:fields) {
            //打开访问开关
            field.setAccessible(true);
            //获取当前私有字段的值
            Object value=field.get(src);
            //根据字段名称获取私有字段
            Field targetField=targetClass.getDeclaredField(field.getName());
            //打开访问开关
            targetField.setAccessible(true);
            //设置当前私有字段的值
            targetField.set(target,value);
        }

    }
}

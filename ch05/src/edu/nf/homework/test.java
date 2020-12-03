package edu.nf.homework;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("id",1001);
        map.put("stuName","张三");
        map.put("age",21);
        //编写一个BeanUtils的工具类，将map集合数据自动转换成实体类型
        Students students=(Students)BeanUtils.convert(map,Students.class);
        System.out.println(students.getId());
        System.out.println(students.getAge());
        System.out.println(students.getStuName());

        //传入任意一个实体对象，转换为map对象
        Map<String,Object> map2=BeanUtils.convertToMap(students);
        for (String key:map2.keySet()) {
            System.out.println(map2.get(key));
        }

        System.out.println("----------------------");
        Students students2=new Students();
        BeanUtils.copy(students,students2);
        System.out.println(students2.getId());
        System.out.println(students2.getStuName());
        System.out.println(students2.getAge());
    }
}

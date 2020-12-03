package edu.nf.ch07;

import java.util.Objects;

/**
 * @author roy
 * 从equals方法的目的是为了重新对比对象的内容是否相等
 * 但同时也需要先重写hashcode方法
 * （hashcode是一种hash算法将内存地址换算成一个int的数值）
 * 当比较两个对象是否相等时，先调用hashcode返回数值来比较，如果hashcode想的则
 * 认为两个的对象是相同的，如果hashcode不相等的，先调用equals方法来比较，
 * 内容是否相等，如果equals返回ture则相等，返回false则不相等
 */
public class Users {
    private String name;
    private Integer age;

    public Users() {
    }

    public Users(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj) {
//        //判断obj是否是当前对象的实例
//        if(obj instanceof  Users){
//            Users u=(Users) obj;
//            //如果当前对象时name和age和传入来的name和age一样，则返回true
//            if(this.name.equals(u.getName()) && this.age.equals(u.getAge())) {
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(name, users.name) &&
                Objects.equals(age, users.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

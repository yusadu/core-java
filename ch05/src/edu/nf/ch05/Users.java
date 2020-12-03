package edu.nf.ch05;

public class Users extends People implements Fly{

    public String userName;
    private String address;

    public  Users(){
        System.out.println("执行构造方法");
    }

    public Users(String Name){
        System.out.println("执行构造方法，Hello "+Name);
    }

    private Users(int status){
        System.out.println("执行构造方法 "+status);
    }

    public void say(String name,int age){
        System.out.println("Hello "+name+" age is "+age);
    }

    private void run(){
        System.out.println("running......");
    }

    @Override
    public void fly() {
        System.out.println("flying......");
    }

}

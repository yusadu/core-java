package edu.nf.ch02;

/**
 *@author wangl
 * @date 2020/20/9
 * 继承是is a的关系（是一个）
 * 方法的重写（覆盖）只能发生在父类和子类之间，
 * 由子类重写父类的非私有方法
 * 注意：静态方法不具备重写特性，只看编译时类型
 * 重写是运行时多态
 *
 *
 * 重载可以发生在本类中，也可以发生在父类和子类之间
 * 重载的要求是方法名称相同，参数个数和类型不同即可
 * 并且构造方法可以重载，但不可以重写
 * 重载是编译时多态
 */
public class JavaTeacher extends Teacher{
    public JavaTeacher(){

    }

    //构造方法重载
    public JavaTeacher(String name){

    }

    @Override
    public void say(){
        System.out.println("Hello JavaTeacher");
    }

    public void hello(){
        System.out.println("Hello sir.");
    }

    public void hello(String name){
        System.out.println("Hello "+name);
    }
}

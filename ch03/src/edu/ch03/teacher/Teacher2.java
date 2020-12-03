package edu.ch03.teacher;

/**
 * @author wangl
 *
 * JDK1.8以后接口中可以定义默认方法
 * 默认方法就是在接口中的一种默认实现
 * 实现类可以针对自身的业务需要重写
 * 这些默认方法
 */
public interface Teacher2 {
    /**
     *
     * 定义默认方法,有方法体
     */
    default  void  call(){
        System.out.println("上课点名");
    };

    default   void code(){

    };

    public void lesson();

    public void homework();
}

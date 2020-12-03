package edu.ch03.teacher;

/**
 * @author wangl
 *
 */
public abstract class Teacher {
    /**
     * 公共的点名方法
     */
    public void call(){
        System.out.println("上课点名");
    }

    /**
     * 抽象的上课方法,不同的老师有不同的授课内容
     * 因此不同的子类实现
     */
    public abstract void lesson();

    /**
     * 布置作业，不通透的老师布置不同的作业
     */
    public abstract  void homework();
}

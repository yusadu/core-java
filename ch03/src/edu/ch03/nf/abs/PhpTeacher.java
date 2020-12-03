package edu.ch03.nf.abs;

public class PhpTeacher extends Teacher{
    @Override
    public void lesson(){
        System.out.println("开始上Php课程");
    }

    @Override
    public void homework(){
        System.out.println("布置Php作业");
    }
}

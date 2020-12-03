package edu.ch03.teacher;

public class PhpTeacher extends Teacher implements Teacher2 {
    @Override
    public void lesson() {
        System.out.println("上Php课程");
    }

    @Override
    public void homework() {
        System.out.println("布置Php作业");
    }

    @Override
    public void code() {

    }
}

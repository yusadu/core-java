package edu.ch03.teacher;

public class EnglishTeacher extends Teacher {
    @Override
    public void lesson() {
        System.out.println("上English课程");
    }

    @Override
    public void homework() {
        System.out.println("布置English作业");
    }


}

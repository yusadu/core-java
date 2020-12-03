package edu.nf.ch06;

@MyAnno("asdf")
public class Users {

    @MyAnno(value="user",name = "sdafs")
    public Users(String name){

    }

    @MyAnno("sdfs")
    private String name;

    @MyAnno(value="hgjj",name="sdfs")
    public void say( @MyAnno(value="hgjj",name="sdfs")String name ,@MyAnno(value="23",name="age")int age){

    }
}

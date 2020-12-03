package org.nf.mvc.test;

import com.google.gson.Gson;
import org.nf.mvc.core.WebRequest;
import org.nf.mvc.models.Users;
import org.nf.mvc.view.AbstractView;
import org.nf.mvc.view.ForwardView;
import org.nf.mvc.view.GsonView;
import org.nf.mvc.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersController{

    @WebRequest(uri="/get")
   public void getUsers(HttpServletRequest request, HttpServletResponse response){
       System.out.println("查询用户");
   }

   @WebRequest(uri="/add")
    public AbstractView addUsers(String name,String sex,int age){
        System.out.println("添加用户");
        System.out.println("姓名："+name);
        System.out.println("性别："+sex);
        System.out.println("年龄"+age);
        return new ForwardView("success.html");
    }

    @WebRequest(uri="/update")
    public AbstractView updateUsers(Users users){
        System.out.println("修改用户");
        System.out.println("姓名："+users.getName());
        System.out.println("性别："+users.getSex());
        System.out.println("年龄："+users.getAge());
        return new GsonView(users);
    }

    @WebRequest(uri="/del")
    public AbstractView delUsers(HttpServletRequest request, HttpServletResponse response){
        System.out.println("删除用户");
        return new RedirectView("success.html");
    }
}

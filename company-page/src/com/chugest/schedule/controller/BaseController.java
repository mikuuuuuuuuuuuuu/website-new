package com.chugest.schedule.controller;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.lang.reflect.Method;
/*
* url后缀接是指后面还有地址用*先表示，比如在浏览器输入/user/add,由extends继承BaseController方法获取当前项目的uri，
 由此取出url要进行add操作，通过反射运行当前类里写的对应的add方法，这里其实是表单会提交action的url指向这个servlet的实现方法，要实现对应
* */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName =split[split.length-1];
        // 通过反射获取要执行的方法
        Class clazz = this.getClass();
        try {
            Method method=clazz.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            // 设置方法可以访问
            method.setAccessible(true);
            // 通过反射执行代码
            //这里this可以用是servlet已经自己创建复用了对象，this指代的就是，不需要newInstance
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

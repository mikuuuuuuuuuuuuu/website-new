package com.chugest.schedule.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
 * 增删改查日程的请求
 * 增 /user/add
 * 删 /user/remove
 * 改/user/update
 * 查/user/find
 *
 * * 登录注册的请求
 * /user/login
 * /user/regist
 * */
/*
* url后缀接是指后面还有地址用*先表示，比如在浏览器输入/user/add,由extends继承BaseController方法获取当前项目的uri，
 由此取出url要进行add操作，通过反射运行当前类里写的对应的add方法，这里其实是表单会提交action的url指向这个servlet的实现方法，要实现对应
* */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
}

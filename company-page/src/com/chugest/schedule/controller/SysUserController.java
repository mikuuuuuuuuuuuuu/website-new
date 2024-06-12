package com.chugest.schedule.controller;

import com.chugest.schedule.common.Result;
import com.chugest.schedule.common.ResultCodeEnum;
import com.chugest.schedule.pojo.SysUser;
import com.chugest.schedule.service.SysUserService;
import com.chugest.schedule.service.impl.SysUserServiceImpl;
import com.chugest.schedule.util.MD5Util;
import com.chugest.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* 增删改查日程的请求
* 增 /user/add
* 删 /user/remove
* 改/user/update
* 查/user/find
*
* 登录注册的请求
* /user/login
* /user/regist
* */
/*
* url后缀接是指后面还有地址用*先表示，比如在浏览器输入/user/add,由extends继承BaseController方法获取当前项目的uri，
 由此取出url要进行add操作，通过反射运行当前类里写的对应的add方法，这里其实是表单会提交action的url指向这个servlet的实现方法，要实现对应
* */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }

    private SysUserService userService=new SysUserServiceImpl();


    /**
     * 注册业务，请求校验用户名是否被占用，配合ajax
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收用户名和密码
        String username = req.getParameter("username");
        //2 调用服务层方法,根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        resp.setCharacterEncoding("utf-8");

        //ResultCodeEnum枚举类,Result的json类
        //封装结果对象
        Result result=null;
        if(null !=loginUser){
            // 占用, 创建一个结果为505的对象
            result= Result.build(null, ResultCodeEnum.USERNAME_USED);
        }else{
            // 未占用,创建一个code为200的对象
            result= Result.ok(null);
        }
        // 将result对象转换为Jason串给客户端
        // 将result对象转换成JSON并响应给客户端
        //ObjectMapper,转化成json串，注意这里不是json对象
        ObjectMapper objectMapper = new ObjectMapper();
        String info = objectMapper.writeValueAsString(result);
        //告诉客户端响应给你的是一个json串
        // 将result对象转换成JSON并响应给客户端
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接收用户登录请求的业务处理方法( 业务接口 不是java中的interface  )
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2 调用服务层方法,根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if (null == loginUser) {
            // 跳转到用户名有误提示页
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            //3 判断密码是否匹配
            // 跳转到密码有误提示页
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            //4 跳转到首页
            //把loginUser传到session域里，让filter获取
            HttpSession session = req.getSession();
            session.setAttribute("sysUser",loginUser);

            resp.sendRedirect("/showSchedule.html");
        }
    }
    /**
     * 接收用户注册请求的业务处理方法( 业务接口 不是java中的interface  )
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 2 调用服务层方法,完成注册功能
        //将参数放入一个SysUser对象中,在调用regist方法时传入
        SysUser sysUser =new SysUser(null,username,userPwd);
       int rows= userService.regist(sysUser);
        // 3 根据注册结果(成功  失败) 做页面跳转
        if(rows>0){
            resp.sendRedirect("/registSuccess.html");
        }else{
            resp.sendRedirect("/registFail.html");
        }
    }
}

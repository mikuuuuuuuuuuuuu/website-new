package com.chugest.schedule.service;


import com.chugest.schedule.pojo.SysUser;

/*
* 定义了以sys_user表为核心的接口
* */
public interface SysUserService {
    /**
     * 用户完成注册的业务方法
     * @param sysUser 用于保存注册用户名和密码的对象
     * @return 注册成功返回>0的整数,否则返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了返回SysUser对象,找不到返回null
     */
    SysUser findByUsername(String username);
}

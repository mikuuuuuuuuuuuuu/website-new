package com.chugest.schedule.service.impl;

import com.chugest.schedule.dao.SysUserDao;
import com.chugest.schedule.dao.impl.SysUserDaoImpl;
import com.chugest.schedule.pojo.SysUser;
import com.chugest.schedule.service.SysUserService;
import com.chugest.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao =new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转换为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 调用DAO 层的方法  将sysUser信息存入数据库，由service实现dao层的方法
        return userDao.addSysUser(sysUser);
    }
    public SysUser findByUsername(String username) {
        // 调用服务层方法,继续查询
        return userDao.findByUsername(username);
    }
}

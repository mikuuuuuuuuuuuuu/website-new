package com.chugest.schedule.dao.impl;

import com.chugest.schedule.dao.BaseDao;
import com.chugest.schedule.dao.SysScheduleDao;
import com.chugest.schedule.pojo.SysSchedule;
import com.chugest.schedule.pojo.SysUser;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysSchedule 要增加的记录的username和user_pwd字段以SysUser实体类对象的形式接收
     * @return 增加成功返回1 增加失败返回0
     */
    @Override
    public int addSysScheduleDao(SysSchedule sysSchedule) {
        String sql="insert into schedule_system.sys_schedule values(DEFAULT,?,?,?)";
        int rows=baseUpdate(sql,sysSchedule.getUid(),sysSchedule.getTitle(),sysSchedule.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from schedule_system.sys_schedule";
        List<SysSchedule> sysUserList = baseQuery(SysSchedule.class, sql);
        //foreach打印对象，会自动调用toStirng方法，pojo类要重写tostring，不然输出的是地址
        sysUserList.forEach(System.out::println);
        return sysUserList;
    }
}

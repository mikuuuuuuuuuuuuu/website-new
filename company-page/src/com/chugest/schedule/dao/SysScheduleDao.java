package com.chugest.schedule.dao;

import com.chugest.schedule.pojo.SysSchedule;

import java.util.List;

/*
* 文档注释
* 类：
* 作者：
* 时间：
*
* */
public interface SysScheduleDao {

    /*增加一条日程记录
    @param schedule 日程数据以SysSchedule实体类对象形式入参
    @return 返回i影响数据库记录的行数，行数0说明增加失败，行数大于0说明增加成功
    * */
    int addSysScheduleDao(SysSchedule sysSchedule);

    /*
    * 查询所有用户的所有日程
    * @return 将所有日程放入一个List<SysSchedule>集合中返回
     * */
    List<SysSchedule> findAll();
}

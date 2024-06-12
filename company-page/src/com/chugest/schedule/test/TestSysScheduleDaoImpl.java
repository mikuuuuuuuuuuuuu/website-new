package com.chugest.schedule.test;

import com.chugest.schedule.dao.SysScheduleDao;
import com.chugest.schedule.dao.impl.SysScheduleDaoImpl;
import com.chugest.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestSysScheduleDaoImpl {
    private static SysScheduleDao scheduleDao;

    @BeforeClass
    public static void initSysScheduleDao(){
        scheduleDao = new SysScheduleDaoImpl();
    }
    @Test
    public void testAddSchedule(){
        int rows=scheduleDao.addSysScheduleDao(new SysSchedule(null,2,"学习数据库",1));
        System.out.println(rows);
    }
    @Test
    public  void testFindAll(){
        List<SysSchedule> sysUserList =scheduleDao.findAll();
        //foreach打印对象，会自动调用toStirng方法，pojo类要重写tostring，不然输出的是地址
        sysUserList.forEach(System.out::println);
    }
}

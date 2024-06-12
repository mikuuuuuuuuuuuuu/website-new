package com.chugest.schedule.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.chugest.schedule.dao.BaseDao;
import com.chugest.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class TestBaseDao {

    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao(){
        baseDao=new BaseDao();
    }
    @Test
    public void testBaseQueryObject(){
        String sql="select count(1) from schedule_system.sys_user";
        Long count=baseDao.baseQueryObject(Long.class,sql);
        System.out.println(count);

    }
    @Test
    public void testBaseQuery(){
        //pojo实体类里定义的userPwd和数据库里user_pwd名称不一样，sql语句要取一个和实体类一样的别名才行
        String sql="select uid,username,user_pwd userPwd from schedule_system.sys_user";
        List<SysUser> sysUserList=baseDao.baseQuery(SysUser.class,sql);
        //foreach打印对象，会自动调用toStirng方法，pojo类要重写tostring，不然输出的是地址
        sysUserList.forEach(System.out::println);
    }
    @Test
    public void testBaseUpdate(){
        String sql ="insert into schedule_system.sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql, 1, "学习java", 0);
        System.out.println(rows);
    }

    @Test
    public void testList(){
        ArrayList<Integer> numbersList = new ArrayList<>();

        // 使用for循环填充列表
        for (int i = 1; i <= 10; i++) {
            numbersList.add(i);
        }

        System.out.println(numbersList);
    }
}

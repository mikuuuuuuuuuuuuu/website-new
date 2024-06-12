package com.chugest.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
/*1 实体类的类名和表格名应该对应（对应不是一致）
 * 2 实体类的属性名和表格名的列名应该一致（参照驼峰写法）
 * 3 每个属性应当是私有的
 * 4 每个属性当具备getter setter
 * 5 必须具备无参构造器，要写出来
 * 6 应该实现序列化接口（缓存 分布式项目数据传递 可能会将对象序列化）
 * 7 应该重写雷达哈是从的和equals方法
 * 8 tostring方法可以写*/

@Getter
@Setter
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private  String userPwd;

    public SysUser() {
    }

    public SysUser(Integer uid, String username, String userPwd) {
        this.uid = uid;
        this.username = username;
        this.userPwd = userPwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(uid, sysUser.uid) &&
                Objects.equals(username, sysUser.username) &&
                Objects.equals(userPwd, sysUser.userPwd);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd);
    }
}


package com.ckd.dubbo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * user类
 *
 * @author diaochengkun
 * @create 2018-11-29
 **/
public class UserVO implements Serializable {

    private Integer id;
    private String name;
    private Date birthDay;
    private int port;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", port=" + port +
                '}';
    }
}

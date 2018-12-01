package com.ckd.dubbo.server.impl;

import com.ckd.dubbo.pojo.UserVO;
import com.ckd.dubbo.server.UserService;

import java.lang.management.ManagementFactory;
import java.util.Date;

/**
 * @author diaochengkun
 * @create 2018-11-29
 **/
public class UserServiceImpl implements UserService {

    int port;

    public UserServiceImpl(){

    }
    public UserServiceImpl(int port){
        this.port = port;
    }
    @Override
    public UserVO getUser(int id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setBirthDay(new Date());
        userVO.setName(ManagementFactory.getRuntimeMXBean().getName());
        userVO.setPort(port);
        return userVO;
    }

    @Override
    public String hello() {
        return "hello,I am from "+port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

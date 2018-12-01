package com.ckd.dubbo.server.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.ckd.dubbo.server.UserService;
import com.ckd.dubbo.server.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author diaochengkun
 * @create 2018-11-29
 **/
public class DubboServer {

    public void buildService(int port){
        ServiceConfig<UserService> serviceConfig  = new ServiceConfig();
        //设置注册中心
        serviceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
        //设置通信协议及端口号
        serviceConfig.setProtocol(new ProtocolConfig("dubbo",port));
        // 设置应用名
        serviceConfig.setApplication(new ApplicationConfig("dubbo-server"));
        //设置暴露服务的接口
        serviceConfig.setInterface(UserService.class);
        UserService userService = new UserServiceImpl();
        //设置暴露服务的实现类
        serviceConfig.setRef(userService);
        //对外暴漏userService服务
        serviceConfig.export();
        int realPort = serviceConfig.getExportedUrls().get(0).getPort();
        ((UserServiceImpl) userService).setPort(realPort);
        System.out.println("dubbo服务已开启："+realPort);
    }
    public static void main(String[] args) throws IOException {
        new DubboServer().buildService(-1);
        System.in.read();
    }
}

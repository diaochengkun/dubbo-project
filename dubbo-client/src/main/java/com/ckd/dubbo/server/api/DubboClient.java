package com.ckd.dubbo.server.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.ckd.dubbo.server.UserService;

/**
 * @author diaochengkun
 * @create 2018-11-29
 **/
public class DubboClient {

    private String remoteUrl = "dubbo://169.254.103.163:20880/com.ckd.dubbo.server.UserService";
    public UserService getUser(){
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setApplication(new ApplicationConfig("dubbo-client"));
        referenceConfig.setUrl(remoteUrl);
//        referenceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
        UserService userService = referenceConfig.get();
        userService.getUser(111);
        return userService;
    }

    public static void main(String[] args) {
        UserService user = new DubboClient().getUser();
        System.out.println(user.getUser(111));
    }
}

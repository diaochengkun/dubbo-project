package com.ckd.dubbo.server;

import com.ckd.dubbo.pojo.UserVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author diaochengkun
 * @create 2018-11-30
 **/
public class SpringConsumerApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        UserService userService = context.getBean(UserService.class);
        while (!"exit".equals(read())){
            UserVO user = userService.getUser(222);
            System.out.println(user);
        }
    }

    public static String read() throws IOException {
        byte[] b = new byte[1024];
        int size = System.in.read(b);
        return new String(b,0,size).trim();
    }
}

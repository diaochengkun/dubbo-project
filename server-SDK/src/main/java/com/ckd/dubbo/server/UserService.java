package com.ckd.dubbo.server;

import com.ckd.dubbo.pojo.UserVO;

/**
 * @author diaochengkun
 * @create 2018-11-29
 **/
public interface UserService {

    UserVO getUser(int id);

    String hello();
}

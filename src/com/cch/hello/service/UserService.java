package com.cch.hello.service;

import com.cch.hello.bean.UserInfo;
import com.cch.hello.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fstar on 2017/1/24.
 */
@Service("userService")
public class UserService {
    @Autowired
    UserDao userDao;

    public UserInfo findUser(String user_id){
               return userDao.findUser(user_id);
    }
}

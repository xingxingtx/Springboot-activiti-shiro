package com.wei.service.user.impl;


import com.wei.dao.UserModel;
import com.wei.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Override
    public UserModel findByUsername(String userName) {
        return null;
    }
}

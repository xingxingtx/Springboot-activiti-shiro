package com.wei.service.user.impl;


import com.wei.mapper.UserMapper;
import com.wei.model.UserModel;
import com.wei.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;
    @Override
    public UserModel findByUsername(String userName) {
        return null;
    }

    @Override
    public Object select(Object o) throws Exception{
        return userMapper.select((UserModel) o);
    }
}

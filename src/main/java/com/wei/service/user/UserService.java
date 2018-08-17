package com.wei.service.user;

import com.wei.model.UserModel;
import com.wei.service.BaseService;


public interface UserService extends BaseService{
    UserModel findByUsername(String userName);

}

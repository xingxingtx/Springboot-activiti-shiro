package com.wei.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserModel extends BaseDao implements Serializable {

    private String userName;
    private String passWord;
    private String phone;
    private String email;
    private List<RoleModel> roleModels;
    private String token;
}

package com.wei.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserModel extends BaseDao implements Serializable {

    private String userName;
    private String passWord;
    private String address;
    private String email;
    private List<RoleModel> roleModels;
    private String token;
    private String sex;
}

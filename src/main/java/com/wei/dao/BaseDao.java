package com.wei.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/16.
 */
@Data
public class BaseDao implements Serializable{
    public Integer id;
    public String createTime;
    public String updateTime;
    public String createUser;
    public String updateUser;
    public Integer state;

}

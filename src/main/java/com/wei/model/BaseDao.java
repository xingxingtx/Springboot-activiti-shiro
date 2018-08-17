package com.wei.model;

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
    public String createBy;
    public String updateBy;
    public Integer state;

}

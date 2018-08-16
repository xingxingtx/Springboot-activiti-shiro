package com.wei.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:ZGP
 * @Desicription:角色
 * @Date:Created in 2018/8/3 9:27
 * @Modified By:
 */
public class RoleModel implements Serializable {

    private Integer id;
    private String name;
    private String describe;
    private Integer state;
    private Integer creater;
    private String createTime;
    private Integer editer;
    private String editTime;

    private List<PermissionModel>  permissionModels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getEditer() {
        return editer;
    }

    public void setEditer(Integer editer) {
        this.editer = editer;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public List<PermissionModel> getPermissionModels() {
        return permissionModels;
    }

    public void setPermissionModels(List<PermissionModel> permissionModels) {
        this.permissionModels = permissionModels;
    }


}

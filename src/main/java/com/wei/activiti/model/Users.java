package com.wei.activiti.model;

/**
 * @Author:Shenzhiwei
 * @Desicription:用户
 * @Date:Created in 2018-07-03 14:05
 * @Modified By:
 */
public class Users {

    private int id;
    private String userName;
    private String deptName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

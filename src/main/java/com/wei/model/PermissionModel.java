package com.wei.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:ZGP
 * @Desicription:权限
 * @Date:Created in 2018/8/3 9:27
 * @Modified By:
 */
@Data
public class PermissionModel extends BaseDao implements Serializable {
    private String name;
    private String url;
    private Integer parent;
    private String code;
    private String describe;
    private Integer editer;
}

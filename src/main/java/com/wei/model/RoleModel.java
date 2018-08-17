package com.wei.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:ZGP
 * @Desicription:角色
 * @Date:Created in 2018/8/3 9:27
 * @Modified By:
 */
@Data
public class RoleModel extends BaseDao implements Serializable {
    private String name;
    private String describe;
    private List<PermissionModel> permissionModels;
}

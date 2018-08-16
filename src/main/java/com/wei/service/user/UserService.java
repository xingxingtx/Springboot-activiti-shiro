package com.wei.service.user;


import com.wei.dao.PermissionModel;
import com.wei.dao.RoleModel;
import com.wei.dao.UserModel;
import org.springframework.dao.DataAccessException;

public interface UserService {
    /**
     * @Author:ZGP
     * @Desicription:  根据用户名查询用户
     * @param username 用户名
     * @Date:Created in 2018/8/3 9:27
     * @Return:userModel
     * @Modified By:
     */
    UserModel findByUsername(String username) throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加权限
     * @param permissionModel 权限
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    int addPermissionModel(PermissionModel permissionModel)throws DataAccessException;

    /**
     * @Author:ZGP
     * @Desicription:  增加角色
     * @param roleModel 角色
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    int addRoleModel(RoleModel roleModel)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加用户
     * @param userModel 用户
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    int addUserModel(UserModel userModel)throws DataAccessException;

    /**
     * @Author:ZGP
     * @Desicription:  增加用户-角色中间表，授予角色
     * @param roleIds 角色id集合
     * @param userId 用户id
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    int addUserRole(int userId, String roleIds)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加用户-角色中间表 授予权限
     * @param roleId 角色id
     * @param permissionIds 权限id集合
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    int addRolePermission(String permissionIds, int roleId)throws DataAccessException;


}

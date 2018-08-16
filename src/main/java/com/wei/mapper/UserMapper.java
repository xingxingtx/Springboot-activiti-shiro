package com.wei.mapper;

import com.wei.dao.PermissionModel;
import com.wei.dao.RoleModel;
import com.wei.dao.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;


/**
 * @Author:ZGP
 * @Desicription: 用户mapper接口
 * @Date:Created in 2018/8/3 9:27
 * @Modified By:
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    /**
     * @Author:ZGP
     * @Desicription:  根据用户名查询用户
     * @param username 用户名
     * @Date:Created in 2018/8/3 9:27
     * @Return:userModel
     * @Modified By:
     */
    UserModel findByUsername(@Param("username") String username)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加权限
     * @param permissionModel 权限
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    void addPermissionModel(@Param("permissionModel") PermissionModel permissionModel)throws DataAccessException;

    /**
     * @Author:ZGP
     * @Desicription:  增加角色
     * @param roleModel 角色
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    void addRoleModel(@Param("roleModel") RoleModel roleModel)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加用户
     * @param userModel 用户
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    void addUserModel(@Param("userModel") UserModel userModel)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加用户-角色中间表
     * @param roleId 角色id
     * @param userId 用户id
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    void addUserRole(@Param("userId") int userId, @Param("roleId") int roleId)throws DataAccessException;
    /**
     * @Author:ZGP
     * @Desicription:  增加用户-角色中间表
     * @param roleId 角色id
     * @param permissionId 用户id
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    void addRolePermission(@Param("permissionId") int permissionId, @Param("roleId") int roleId)throws DataAccessException;

}

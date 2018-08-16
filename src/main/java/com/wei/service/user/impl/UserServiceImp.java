package com.wei.service.user.impl;


import com.wei.dao.PermissionModel;
import com.wei.dao.RoleModel;
import com.wei.dao.UserModel;
import com.wei.mapper.UserMapper;
import com.wei.service.user.UserService;
import com.wei.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Author:ZGP
     * @Desicription:  根据用户名查询用户
     * @param username 用户名
     * @Date:Created in 2018/8/3 9:27U
     * @Return:userModel
     *@Modified By:
     */
    public UserModel findByUsername(String username)throws DataAccessException {
        return userMapper.findByUsername(username);
    }

    /**
     * @Author:ZGP
     * @Desicription:  增加权限
     * @param permissionModel 权限
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    public int addPermissionModel(PermissionModel permissionModel)throws DataAccessException {
        userMapper.addPermissionModel(permissionModel);
        return permissionModel.getId();
    }

    /**
     * @Author:ZGP
     * @Desicription:  增加角色
     * @param roleModel 角色
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    public int addRoleModel(RoleModel roleModel) throws DataAccessException {
        userMapper.addRoleModel(roleModel);
        return roleModel.getId();
    }

    /**
     * @Author:ZGP
     * @Desicription:  增加用户
     * @param userModel 用户
     * @Date:Created in 2018/8/3 9:27
     * @Return:int
     * @Modified By:
     */
    public int addUserModel(UserModel userModel)throws DataAccessException {
        userModel.setPassWord(Utils.getMd5DigestAsHex(userModel.getPassWord()));
        userMapper.addUserModel(userModel);
        return userModel.getId();
    }

    /**
     * @Author:ZGP
     * @Desicription:  增加用户-角色中间表，授予角色
     * @param roleIds 角色id集合
     * @param userId 用户id
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    public int addUserRole(int userId, String roleIds) throws DataAccessException {
        String[] ids=roleIds.split(",");
        for(String id:ids){
            userMapper.addUserRole(userId,Integer.parseInt(id));
        }
        return ids.length;
    }

    /**
     * @Author:ZGP
     * @Desicription:  增加角色-权限中间表
     * @param roleId 角色id
     * @param permissionIds 用户id
     * @Date:Created in 2018/8/3 9:27
     * @Return:void
     * @Modified By:
     */
    public int addRolePermission(String permissionIds, int roleId)throws DataAccessException {
        String[] ids=permissionIds.split(",");
        for(String id:ids){
            userMapper.addRolePermission(roleId,Integer.parseInt(id));
        }
        return ids.length;
    }
}

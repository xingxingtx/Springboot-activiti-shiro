package com.wei.mapper;

import com.wei.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author:ZGP
 * @Desicription: 用户mapper接口
 * @Date:Created in 2018/8/3 9:27
 * @Modified By:
 */
@Repository
public interface UserMapper {

    List<UserModel> select(UserModel model) throws Exception;
}

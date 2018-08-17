package com.wei.contorller.user;

/**
 * Created by Administrator on 2018/8/16.
 */

import com.wei.model.UserModel;
import com.wei.service.user.UserService;
import com.wei.util.JsonResponseData;
import com.wei.util.StatusDefine;
import com.wei.util.StatusDefineMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("user Controller")
@RestController
public class UserController {
    public Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户管理-用户查询", httpMethod = "GET", response = String.class, notes = "用户管理-用户查询,提供给XXX系统用户管理-用户查询功能使用")
    @RequestMapping(value = "/api/selectUser", method = RequestMethod.GET)
    public  String selectUser(@ApiParam(value = "用户对象",required = false) @RequestParam(value = "user",required = false)UserModel user,
                              @ApiParam(value = "token", required = false) @RequestParam(value = "token",required = false)String token
                              ){
        try{
            List<UserModel> listUser = (List<UserModel>)userService.select(user);
            return new JsonResponseData(true, "用户查询成功", StatusDefine.SUCCESS,
                    StatusDefineMessage.GetMessage(StatusDefine.SUCCESS), listUser).toString();
        }catch (Exception e){
            log.debug(e.getMessage());
        }
        return new JsonResponseData(false, "数据库异常", StatusDefine.DB_ERROR,
                StatusDefineMessage.GetMessage(StatusDefine.DB_ERROR), null).toString();
    }

}

package com.wei.util;

/**
 * Created by psl on 2018-04-03.
 */
public class StatusDefineMessage {
    //获取常量信息
    public static String GetMessage(int s) {
        switch (s) {
            case StatusDefine.SUCCESS:
                return "操作成功";
            case StatusDefine.FAILURE:
                return "操作失败";
            case StatusDefine.U_INEXISTENCE:
                return "用户不存在";
            case StatusDefine.U_PWD_FAILED:
                return "用户密码错误";
            case StatusDefine.U_UNCHANGE_PWD:
                return "用户密码未经修改";
            case StatusDefine.U_UNACTIVE:
                return "用户未激活";
            case StatusDefine.U_TOKEN_ERROR:
                return "用户授权码错误";
            case StatusDefine.U_NO_TOKEN:
                return "用户未授权";
            case StatusDefine.U_AUTH_ERROR:
                return "用户无操作权限";
            case StatusDefine.U_ADD_FAILED:
                return "用户添加失败";
            case StatusDefine.SYS_ERROR:
                return "系统错误";
            case StatusDefine.NET_ERROR:
                return "网络请求失败";
            case StatusDefine.DB_ERROR:
                return "数据库访问失败";
            case StatusDefine.FILE_SERVICE_ERROR:
                return "文件服务器出错";
            case StatusDefine.DATA_FORMAT_ERROR:
                return "数据格式错误";
            case StatusDefine.JSON_FORMAT_ERROR:
                return "JSON格式错误";

            case StatusDefine.MSG_SEND_ERROR:
                return "短信发送失败";
            case StatusDefine.READ_EXCEL_ERROR:
                return "读取EXCEL文件失败";
            case StatusDefine.FILE_FORMAT_ERROR:
                return "文件格式错误";
            case StatusDefine.U_UNLOAD:
                return "用户未登录";
            case StatusDefine.U_LOGIN_OUTTIME:
                return "登录超时,请重新登录";
            case StatusDefine.REDIS_SERVICE_ERROR:
                return "缓存服务器出错";
            case StatusDefine.ISNULLPARAM:
                return "传入参数为空";
            case StatusDefine.ARITHMRTIC:
                return "除数为0，出现异常";
            case StatusDefine.FILENOTFOUND:
                return "导入文件文件不存在";
            case StatusDefine.DATA_NOT_EXIST:
                return "数据不存在";
            case StatusDefine.IMG_VEDIO_MAX_LIMIT:
                return "图片与视频总数超过限制,最大为："+ConstDefine.IMG_VEDIO_CNT_MAX;
            case StatusDefine.INJURED_CNT_MAX_LIMIT:
                return "受害人数量超过限制,最大为："+ConstDefine.INJURED_CNT_MAX;
            case StatusDefine.SUSPECT_CNT_MAX_LIMIT:
                return "嫌疑人数量超过限制,最大为："+ConstDefine.SUSPECT_CNT_MAX;
            case StatusDefine.CARINFO_CNT_MAX_LIMIT:
                return "涉案车辆数量超过限制,最大为："+ConstDefine.CARINFO_CNT_MAX;
            default:
                return "";
        }
    }
}

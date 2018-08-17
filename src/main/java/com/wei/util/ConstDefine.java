package com.wei.util;

/**
 * @Author:cat
 * @Desicription:
 * @Date:Created in 2017-11-07 10:49
 * @Modified By:
 */
public interface ConstDefine {
    /**数据状态*/
    /**删除*/
    int STATE_DISABLE = -1;
    /**启用*/
    int STATE_ABLE = 1;
    //性别
    //男
    int GENDER_MALE = 1;
    //女
    int GENDER_FEMALE = 2;
    //生日类型
    //阳历生日
    int BIRTHDAY_TYPE_0 = 0;
    //阴历生日
    int BIRTHDAY_TYPE_1 = 1;
    /**系统视频、图片表img_video中type 类型：1现场情况，2受害人，3嫌疑人*/
    int IMG_VIDEO_TYPE_SCENE=1;
    int IMG_VIDEO_TYPE_INJURED=2;
    int IMG_VIDEO_TYPE_SUSPECT=3;

    /**系统参数表中type 类型：1案件性质，2发案原因，3发案辖区，4发案地点，5线索来源*/
    int PARAM_TYPE_CTYPE=1;
    int PARAM_TYPE_CREASON=2;
    int PARAM_TYPE_CSTATION=3;
    int PARAM_TYPE_CADRESS=4;
    int PARAM_TYPE_CSOURCE=5;
    /**系统权限编码 10000涉恶警情主页, 10001 查看本派出所警情,10002查看所有警情,10003录入警情,10004修改自己录入警情,10005修改本派出所警情,10006修改所有警情*/
    int AUTH_INVOLVE_MAIN=10000;
    int AUTH_INVOLVE_VIEW_ORG=10001;
    int AUTH_INVOLVE_VIEW_ALL=10002;
    int AUTH_INVOLVE_ADD=10003;
    int AUTH_INVOLVE_EDIT_SELF=10004;
    int AUTH_INVOLVE_EDIT_ORG=10005;
    int AUTH_INVOLVE_EDIT_ALL=10006;
    //图片视频总个数限制
    int IMG_VEDIO_CNT_MAX=9;
    //受害人数量限制
    int INJURED_CNT_MAX=10;
    //嫌疑人数量限制
    int SUSPECT_CNT_MAX=10;
    //涉案车辆数量限制
    int CARINFO_CNT_MAX=10;
    /**数据库默认密码*/
    String DEFAULT_PWD="123456";
    /**创建账号、重置默认密码*/
    String USER_PWD="88888888";

}

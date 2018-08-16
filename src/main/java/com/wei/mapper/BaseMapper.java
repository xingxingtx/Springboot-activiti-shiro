package com.wei.mapper;

/**
 * Created by Administrator on 2018/8/16.
 */
public interface BaseMapper<T> {

    //修改
    public  Integer update(T t);

    //删除
    public Integer  delete(T t);
    //查询
    public T select(T t);

}

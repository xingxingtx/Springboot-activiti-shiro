package com.wei.service;

/**
 * Created by Administrator on 2018/8/16.
 */
public interface BaseService<T> {

        T select(T t) throws Exception;
}

package com.example.restfull.service.server;


import java.util.List;

/**
 * 创建时间:2019/7/22
 * 创建人:pmc
 * 描述:
 */
public interface Servcommon<T>
{
    int add(T t);

    int updateAll(T t);

    int updateNoNull(T t);

    int delete(T t);

    T selectKey(T t);

    T selectKey(String key);

    List<T> selectList(T t);
}

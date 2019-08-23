package com.example.restfull.service.server;


import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 创建时间:2019/7/22
 * 创建人:pmc
 * 描述:
 */
public interface ServCommon<T>
{
    int add(T t);

    int updateAll(T t);

    int updateNoNull(T t);

    int delete(Integer id);

    T selectKey(T t);

    T selectKey(String key);

    List<T> selectList(T t);

    ResponseEntity<?> returnResponseOK();
}

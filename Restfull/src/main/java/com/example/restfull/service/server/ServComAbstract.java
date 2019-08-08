package com.example.restfull.service.server;

import com.example.restfull.common.ComReturn;
import org.springframework.http.ResponseEntity;

/**
 * 创建时间:2019/8/7
 * 创建人:pmc
 * 描述:
 */
public abstract class ServComAbstract<T> implements ServCommon<T>
{
    protected Object comResponseEntity = null;//共用返回对象

    public ResponseEntity<?> returnResponseOK()
    {
        return ComReturn.responseReturnOK(comResponseEntity);
    }
}

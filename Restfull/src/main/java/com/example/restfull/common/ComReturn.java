package com.example.restfull.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
public class ComReturn
{
    /**
     * 公共返回值
     *
     * @param object     返回对象
     * @param httpStatus 返回状态值
     * @return
     */
    public static ResponseEntity<?> responseReturn(Object object, HttpStatus httpStatus)
    {
        ResponseEntity<?> responseEntity = new ResponseEntity<>(object, httpStatus);
        return responseEntity;
    }

    /**
     * 返回正常
     *
     * @param object
     * @return
     */
    public static ResponseEntity<?> responseReturnOK(Object object)
    {
        return responseReturn(object, HttpStatus.OK);
    }

    /**
     * 返回内部服务器错误
     *
     * @param object
     * @return
     */
    public static ResponseEntity<?> responseReturnError(Object object)
    {
        return responseReturn(object, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

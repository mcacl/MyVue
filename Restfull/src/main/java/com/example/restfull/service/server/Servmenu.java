package com.example.restfull.service.server;

import com.example.restfull.common.ComReturn;
import com.example.restfull.model.SysMenu;
import org.springframework.http.ResponseEntity;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
public interface Servmenu extends Servcommon<SysMenu>
{
    Object comResponseEntity = null;

    default ResponseEntity<?> returnResponseOK()
    {
        return ComReturn.responseReturnOK(comResponseEntity);
    }
}

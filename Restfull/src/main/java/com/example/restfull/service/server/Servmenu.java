package com.example.restfull.service.server;

import org.springframework.http.ResponseEntity;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
public interface Servmenu
{
    ResponseEntity<?> menuAdd();

    ResponseEntity<?> menuGet();
}

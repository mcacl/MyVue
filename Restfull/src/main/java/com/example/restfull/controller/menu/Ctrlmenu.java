package com.example.restfull.controller.menu;

import com.example.restfull.service.implserver.Implservmenu;
import com.example.restfull.service.server.Servmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/7/18
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/menu")
public class Ctrlmenu implements Servmenu
{
    @Autowired
    private Implservmenu implservmenu;

    @Override
    @RequestMapping(value = "/menuadd")
    public ResponseEntity<?> menuAdd()
    {
        return implservmenu.menuAdd();
    }

    @Override
    @RequestMapping(value = "/menuget")
    public ResponseEntity<?> menuGet()
    {
        return implservmenu.menuGet();
    }
}

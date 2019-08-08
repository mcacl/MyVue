package com.example.restfull.controller.menu;

import com.example.restfull.model.SysMenu;
import com.example.restfull.service.implserver.ImplServMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/7/18
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/menu")
public class Ctrlmenu
{
    @Autowired
    private ImplServMenu implServMenu;

    @RequestMapping(value = "/menuadd")
    public ResponseEntity<?> add(SysMenu sysMenu)
    {
        implServMenu.add(sysMenu);
        return implServMenu.returnResponseOK();
    }


    @RequestMapping(value = "/menuupdateall")
    public ResponseEntity<?> updateAll(SysMenu sysMenu)
    {
        implServMenu.updateAll(sysMenu);
        return implServMenu.returnResponseOK();
    }


    @RequestMapping(value = "/menuupdatenonull")
    public ResponseEntity<?> updateNoNull(SysMenu sysMenu)
    {
        implServMenu.updateNoNull(sysMenu);
        return implServMenu.returnResponseOK();
    }


    @RequestMapping(value = "/menuget")
    public ResponseEntity<?> menuGetKey(@RequestBody(required = false) SysMenu sysMenu)
    {
        implServMenu.selectList(sysMenu);
        return implServMenu.returnResponseOK();
    }
}

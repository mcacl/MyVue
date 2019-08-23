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
public class CtrlMenu
{
    @Autowired
    private ImplServMenu implServMenu;

    @RequestMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody SysMenu sysMenu)
    {
        implServMenu.add(sysMenu);
        return implServMenu.returnResponseOK();
    }


    @RequestMapping(value = "/updateall")
    public ResponseEntity<?> updateAll(@RequestBody SysMenu sysMenu)
    {
        implServMenu.updateAll(sysMenu);
        return implServMenu.returnResponseOK();
    }


    @RequestMapping(value = "/updatenonull")
    public ResponseEntity<?> updateNoNull(@RequestBody SysMenu sysMenu)
    {
        implServMenu.updateNoNull(sysMenu);
        return implServMenu.returnResponseOK();
    }

    @RequestMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody SysMenu sysMenu)
    {
        implServMenu.delete(sysMenu.getMenuid());
        return implServMenu.returnResponseOK();
    }

    @RequestMapping(value = "/list")
    public ResponseEntity<?> list(@RequestBody(required = false) SysMenu sysMenu)
    {
        implServMenu.selectList(sysMenu);
        return implServMenu.returnResponseOK();
    }
}

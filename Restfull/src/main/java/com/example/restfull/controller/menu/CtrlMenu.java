package com.example.restfull.controller.menu;

import com.example.restfull.common.ImplIComAbstract;
import com.example.restfull.model.SysMenu;
import com.example.restfull.service.implserver.ImplMenu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/7/18
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/menu")
public class CtrlMenu extends ImplIComAbstract<SysMenu, ImplMenu>
{
}

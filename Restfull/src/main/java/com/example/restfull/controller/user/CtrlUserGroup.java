package com.example.restfull.controller.user;

import com.example.restfull.common.ImplIComAbstract;
import com.example.restfull.model.SysUserGroup;
import com.example.restfull.service.implserver.ImplUserGroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/8/28
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/usergroup")
public class CtrlUserGroup extends ImplIComAbstract<SysUserGroup, ImplUserGroup>
{

}
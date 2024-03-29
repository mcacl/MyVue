package com.example.restfull.controller.user;

import com.example.restfull.common.ImplIComAbstract;
import com.example.restfull.model.SysUser;
import com.example.restfull.service.implserver.ImplUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/user")
public class CtrlUser extends ImplIComAbstract<SysUser, ImplUser>
{

}

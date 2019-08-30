package com.example.restfull.controller.user;

import com.example.restfull.common.ImplIComAbstract;
import com.example.restfull.model.SysAuthority;
import com.example.restfull.service.implserver.ImplUserAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/8/30
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/userauthor")
public class CtrlUserAuthority extends ImplIComAbstract<SysAuthority,ImplUserAuthority>
{
}

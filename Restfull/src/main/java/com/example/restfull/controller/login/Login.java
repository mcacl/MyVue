package com.example.restfull.controller.login;

import com.example.restfull.model.SysUser;
import com.example.restfull.service.implserver.ImplLoginUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/9/9
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/login")
public class Login
{
    @Autowired
    private ImplLoginUserDetailsService implLogin;

    @RequestMapping(value = "/in")
    public ResponseEntity<?> loginin(@RequestBody SysUser sysUser)
    {
        Object object = implLogin.loginin(sysUser);
        ResponseEntity<?> responseEntity = new ResponseEntity(object, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/out")
    public ResponseEntity<?> loginout(@RequestBody SysUser sysUser)
    {
        ResponseEntity<?> responseEntity = new ResponseEntity(null, HttpStatus.OK);
        return responseEntity;
    }
}

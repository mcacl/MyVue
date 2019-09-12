package com.example.restfull.service.implserver;

import com.example.restfull.model.SysUser;
import com.example.restfull.model.SysUserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间:2019/9/9
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplLoginUserDetailsService implements UserDetailsService
{
    @Autowired
    private ImplUser implUser;
    @Autowired
    private ImplUserGroup implUserGroup;
    @Autowired
    private ImplUserAuthority implUserAuthority;

    public UserDetails loginin(SysUser sysUser)
    {
        /*String pas = sysUser.getPas();
        sysUser.setPas(ToolCryptography.MD5(pas));
        SysUser user = implUser.selectFirstOrNull(sysUser);
        if (user != null)
        {
            user.setPas(null);
        }*/
        UserDetails userDetails = loadUserByUsername(sysUser.getLoginname());
        return userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String loginname) throws UsernameNotFoundException
    {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        //SysUser user = implUser.selectFirstOrNull(new SysUser(loginname));
        SysUser user = implUser.selectKey("1");

        // 判断用户是否存在
        if (user == null)
        {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        SysUserGroup userRoles = implUserGroup.selectKey(user.getGroupid() + "");
        if (userRoles != null)
        {
            authorities.add(new SimpleGrantedAuthority(userRoles.getGroupname()));
        }
        // 返回UserDetails实现类
        return new User(user.getName(), user.getPas(), authorities);
    }
}

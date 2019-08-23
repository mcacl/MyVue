package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysMenuMapper;
import com.example.restfull.model.SysMenu;
import com.example.restfull.service.server.ServMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplServMenu extends ServMenu
{
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public int add(SysMenu sysMenu)
    {
        int num = sysMenuMapper.insertSelective(sysMenu);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int updateAll(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKey(sysMenu);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int updateNoNull(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int delete(Integer id)
    {
        int num = sysMenuMapper.deleteByPrimaryKey(id);
        comResponseEntity = num;
        return num;
    }

    @Override
    public SysMenu selectKey(SysMenu sysMenu)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(sysMenu.getMenuid());
        comResponseEntity = entity;
        return entity;
    }

    @Override
    public SysMenu selectKey(String key)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(Integer.getInteger(key));
        comResponseEntity = entity;
        return entity;
    }

    @Override
    public List<SysMenu> selectList(SysMenu sysMenu)
    {
        List<SysMenu> list = sysMenuMapper.selectList(sysMenu);
        comResponseEntity = list;
        return list;
    }
}

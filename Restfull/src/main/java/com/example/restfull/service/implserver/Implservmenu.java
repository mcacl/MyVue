package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysMenuMapper;
import com.example.restfull.model.SysMenu;
import com.example.restfull.service.server.Servmenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
@Service
public class Implservmenu implements Servmenu
{
    private Object _responseEntity = comResponseEntity;
    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public int add(SysMenu sysMenu)
    {
        int num = sysMenuMapper.insertSelective(sysMenu);
        _responseEntity = num;
        return num;
    }

    @Override
    public int updateAll(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKey(sysMenu);
        _responseEntity = num;
        return num;
    }

    @Override
    public int updateNoNull(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        _responseEntity = num;
        return num;
    }

    @Override
    public int delete(SysMenu sysMenu)
    {
        int num = sysMenuMapper.deleteByPrimaryKey(sysMenu.getMenuid());
        _responseEntity = num;
        return num;
    }

    @Override
    public SysMenu selectKey(SysMenu sysMenu)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(sysMenu.getMenuid());
        _responseEntity = entity;
        return entity;
    }

    @Override
    public SysMenu selectKey(String key)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(Integer.getInteger(key));
        _responseEntity = entity;
        return entity;
    }

    @Override
    public List<SysMenu> selectList(SysMenu sysMenu)
    {
        List<SysMenu> list = sysMenuMapper.selectList(sysMenu);
        _responseEntity = list;
        return list;
    }

    public ResponseEntity<?> menuGetTest(SysMenu sysMenu)
    {
        String objects = "[{\"name\":\"菜单1\",\"menuid\":\"1\",\"icon\":\"ios-navigate\",\"data\":{\"component\":\"\"},\"childs\":[{\"name\":\"子菜单1-1\",\"menuid\":\"1-1\",\"icon\":\"ios-keypad\",\"component\":\"Test1\",\"data\":{},\"childs\":[]}]},{\"name\":\"菜单2\",\"menuid\":\"2\",\"icon\":\"ios-navigate\",\"data\":{\"component\":\"\"},\"childs\":[{\"name\":\"子菜单2-1\",\"menuid\":\"2-1\",\"icon\":\"ios-keypad\",\"component\":\"Test2\",\"data\":{},\"childs\":[]}]}]";
        //_responseEntity = objects;
        //_responseEntity = selectList(sysMenu);
        _responseEntity = selectKey("1");
        return returnResponseOK();
    }
}

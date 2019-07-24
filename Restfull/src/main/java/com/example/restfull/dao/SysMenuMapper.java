package com.example.restfull.dao;

import com.example.restfull.model.SysMenu;

import java.util.List;

public interface SysMenuMapper
{
    int deleteByPrimaryKey(Integer menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectList(SysMenu sysMenu);
}
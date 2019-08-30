package com.example.restfull.dao;

import com.example.restfull.model.SysUserGroup;

import java.util.List;

public interface SysUserGroupMapper
{
    int deleteByPrimaryKey(Integer groupid);

    int insert(SysUserGroup record);

    int insertSelective(SysUserGroup record);

    SysUserGroup selectByPrimaryKey(Integer groupid);

    int updateByPrimaryKeySelective(SysUserGroup record);

    int updateByPrimaryKey(SysUserGroup record);

    List<SysUserGroup> selectList(SysUserGroup sysUserGroup);
}
package com.example.restfull.dao;

import com.example.restfull.model.SysUser;

import java.util.List;

public interface SysUserMapper
{
    int deleteByPrimaryKey(Integer userid);

    int deleteInKey(int[] ids);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectList(SysUser sysUser);
}
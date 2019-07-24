package com.example.restfull.dao;

import com.example.restfull.model.SysAuthority;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}
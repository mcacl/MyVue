package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysUserMapper;
import com.example.restfull.model.SysUser;
import com.example.restfull.service.server.ImplIServComAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplUser extends ImplIServComAbstract<SysUser>
{
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 添加t
     *
     * @param sysUser 表实体
     * @return 影响数目
     */
    @Override
    public int add(SysUser sysUser)
    {
        int num = sysUserMapper.insertSelective(sysUser);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 全实体更新
     *
     * @param sysUser 表实体
     * @return 影响数目
     */
    @Override
    public int updateAll(SysUser sysUser)
    {
        int num = sysUserMapper.updateByPrimaryKey(sysUser);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 非空实体数据更新
     *
     * @param sysUser 表实体
     * @return 影响数目
     */
    @Override
    public int updateNoNull(SysUser sysUser)
    {
        int num = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        comResponseEntity = num;
        return num;
    }

    /**
     * 删除数据
     *
     * @param id 主键值
     * @return 影响数目
     */
    @Override
    public int delete(Integer id)
    {
        int num = sysUserMapper.deleteByPrimaryKey(id);
        comResponseEntity = num;
        return num;
    }

    /**
     * 删除数据批量
     *
     * @param ids 主键值数组
     * @return 影响数目
     */
    @Override
    public int deleteIn(int[] ids)
    {
        int num = sysUserMapper.deleteInKey(ids);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更据主键查询实体
     *
     * @param sysUser 实体
     * @return 实体
     */
    @Override
    public SysUser selectKey(SysUser sysUser)
    {
        SysUser entity = sysUserMapper.selectByPrimaryKey(sysUser.getUserid());
        comResponseEntity = entity;
        return entity;
    }

    /**
     * 更据主键查询实体
     *
     * @param key 实体
     * @return 实体
     */
    @Override
    public SysUser selectKey(String key)
    {
        SysUser entity = sysUserMapper.selectByPrimaryKey(Integer.getInteger(key));
        comResponseEntity = entity;
        return entity;
    }

    /**
     * 更据实体条件查询数据
     *
     * @param sysUser 实体
     * @return 实体集合
     */
    @Override
    public List<SysUser> selectList(SysUser sysUser)
    {
        List<SysUser> list = sysUserMapper.selectList(sysUser);
        comResponseEntity = list;
        return list;
    }
}

package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysUserGroupMapper;
import com.example.restfull.model.SysUserGroup;
import com.example.restfull.service.server.ImplIServComAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/8/28
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplUserGroup extends ImplIServComAbstract<SysUserGroup>
{
    @Autowired
    SysUserGroupMapper sysUserGroupMapper;

    /**
     * 添加t
     *
     * @param sysUserGroup 表实体
     * @return 影响数目
     */
    @Override
    public int add(SysUserGroup sysUserGroup)
    {
        int num = sysUserGroupMapper.insertSelective(sysUserGroup);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 全实体更新
     *
     * @param sysUserGroup 表实体
     * @return 影响数目
     */
    @Override
    public int updateAll(SysUserGroup sysUserGroup)
    {
        int num = sysUserGroupMapper.updateByPrimaryKey(sysUserGroup);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 非空实体数据更新
     *
     * @param sysUserGroup 表实体
     * @return 影响数目
     */
    @Override
    public int updateNoNull(SysUserGroup sysUserGroup)
    {
        int num = sysUserGroupMapper.updateByPrimaryKeySelective(sysUserGroup);
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
        int num = sysUserGroupMapper.deleteByPrimaryKey(id);
        comResponseEntity = num;
        return num;
    }

    /**
     * 删除数据批量 暂不实现
     *
     * @param ids 主键值数组
     * @return 影响数目
     */
    @Override
    public int deleteIn(int[] ids)
    {
        return 0;//暂不实现
    }

    /**
     * 更据主键查询实体
     *
     * @param sysUserGroup 实体
     * @return 实体
     */
    @Override
    public SysUserGroup selectKey(SysUserGroup sysUserGroup)
    {
        SysUserGroup entity = sysUserGroupMapper.selectByPrimaryKey(sysUserGroup.getGroupid());
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
    public SysUserGroup selectKey(String key)
    {
        SysUserGroup entity = sysUserGroupMapper.selectByPrimaryKey(Integer.getInteger(key));
        comResponseEntity = entity;
        return entity;
    }

    /**
     * 更据实体条件查询数据
     *
     * @param sysUserGroup 实体
     * @return 实体集合
     */
    @Override
    public List<SysUserGroup> selectList(SysUserGroup sysUserGroup)
    {
        List<SysUserGroup> list = sysUserGroupMapper.selectList(sysUserGroup);
        comResponseEntity = list;
        return list;
    }
}

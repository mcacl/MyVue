package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysAuthorityMapper;
import com.example.restfull.model.SysAuthority;
import com.example.restfull.service.server.ImplIServComAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/8/30
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplUserAuthority extends ImplIServComAbstract<SysAuthority>
{
    @Autowired
    SysAuthorityMapper sysAuthorityMapper;

    /**
     * 添加t
     *
     * @param sysAuthority 表实体
     * @return 影响数目
     */
    @Override
    public int add(SysAuthority sysAuthority)
    {
        int num = sysAuthorityMapper.insertSelective(sysAuthority);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 全实体更新
     *
     * @param sysAuthority 表实体
     * @return 影响数目
     */
    @Override
    public int updateAll(SysAuthority sysAuthority)
    {
        int num = sysAuthorityMapper.updateByPrimaryKey(sysAuthority);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 非空实体数据更新
     *
     * @param sysAuthority 表实体
     * @return 影响数目
     */
    @Override
    public int updateNoNull(SysAuthority sysAuthority)
    {
        int num = sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority);
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
        int num = sysAuthorityMapper.deleteByPrimaryKey(id);
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
     * @param sysAuthority 实体
     * @return 实体
     */
    @Override
    public SysAuthority selectKey(SysAuthority sysAuthority)
    {
        SysAuthority entity = sysAuthorityMapper.selectByPrimaryKey(sysAuthority.getId());
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
    public SysAuthority selectKey(String key)
    {
        SysAuthority entity = sysAuthorityMapper.selectByPrimaryKey(Integer.getInteger(key));
        comResponseEntity = entity;
        return entity;
    }

    /**
     * 更据实体条件查询数据
     *
     * @param sysAuthority 实体
     * @return 实体集合
     */
    @Override
    public List<SysAuthority> selectList(SysAuthority sysAuthority)
    {
        List<SysAuthority> list = sysAuthorityMapper.selectList(sysAuthority);
        comResponseEntity = list;
        return list;
    }
}

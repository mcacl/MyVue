package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysMenuMapper;
import com.example.restfull.model.SysMenu;
import com.example.restfull.service.server.ImplIServComAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplMenu extends ImplIServComAbstract<SysMenu>
{
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 添加t
     *
     * @param sysMenu 表实体
     * @return 影响数目
     */
    @Override
    public int add(SysMenu sysMenu)
    {
        int num = sysMenuMapper.insertSelective(sysMenu);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 全实体更新
     *
     * @param sysMenu 表实体
     * @return 影响数目
     */
    @Override
    public int updateAll(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKey(sysMenu);
        comResponseEntity = num;
        return num;
    }

    /**
     * 更新t 非空实体数据更新
     *
     * @param sysMenu 表实体
     * @return 影响数目
     */
    @Override
    public int updateNoNull(SysMenu sysMenu)
    {
        int num = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
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
        int num = sysMenuMapper.deleteByPrimaryKey(id);
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
     * @param sysMenu 实体
     * @return 实体
     */
    @Override
    public SysMenu selectKey(SysMenu sysMenu)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(sysMenu.getMenuid());
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
    public SysMenu selectKey(String key)
    {
        SysMenu entity = sysMenuMapper.selectByPrimaryKey(Integer.parseInt(key));
        comResponseEntity = entity;
        return entity;
    }

    /**
     * 更据实体条件查询数据
     *
     * @param sysMenu 实体
     * @return 实体集合
     */
    @Override
    public List<SysMenu> selectList(SysMenu sysMenu)
    {
        List<SysMenu> list = sysMenuMapper.selectList(sysMenu);
        comResponseEntity = list;
        return list;
    }
}

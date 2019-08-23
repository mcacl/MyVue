package com.example.restfull.service.implserver;

import com.example.restfull.dao.SysUserMapper;
import com.example.restfull.model.SysUser;
import com.example.restfull.model.extend.PageModel;
import com.example.restfull.service.server.ServUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplServUser extends ServUser
{
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int add(SysUser sysUser)
    {
        int num = sysUserMapper.insertSelective(sysUser);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int updateAll(SysUser sysUser)
    {
        int num = sysUserMapper.updateByPrimaryKey(sysUser);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int updateNoNull(SysUser sysUser)
    {
        int num = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        comResponseEntity = num;
        return num;
    }

    @Override
    public int delete(Integer id)
    {
        int num = sysUserMapper.deleteByPrimaryKey(id);
        comResponseEntity = num;
        return num;
    }

    @Override
    public SysUser selectKey(SysUser sysUser)
    {
        SysUser entity = sysUserMapper.selectByPrimaryKey(sysUser.getUserid());
        comResponseEntity = entity;
        return entity;
    }

    @Override
    public SysUser selectKey(String key)
    {
        SysUser entity = sysUserMapper.selectByPrimaryKey(Integer.getInteger(key));
        comResponseEntity = entity;
        return entity;
    }

    @Override
    public List<SysUser> selectList(SysUser sysUser)
    {
        List<SysUser> list = sysUserMapper.selectList(sysUser);
        comResponseEntity = list;
        return list;
    }

    /**
     * 分页公共接口
     *
     * @param pageModel 当前页
     * @return PageInfo
     */
    @Override
    public ResponseEntity<?> selectPage(PageModel<SysUser> pageModel)
    {
        PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());//开始分页对象必须使用 否则可能会有错误
        List<SysUser> list = selectList(pageModel.getT());
        PageInfo pageInfo = new PageInfo(list);
        comResponseEntity = pageInfo;
        return returnResponseOK();
    }

    /**
     * 批量删除
     *
     * @param ids id[]
     * @return num
     */
    @Override
    public ResponseEntity<?> deleteIn(Integer[] ids)
    {
        int num = sysUserMapper.deleteInKey(ids);
        comResponseEntity = num;
        return returnResponseOK();
    }
}

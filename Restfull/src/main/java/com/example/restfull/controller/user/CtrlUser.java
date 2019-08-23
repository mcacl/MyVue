package com.example.restfull.controller.user;

import com.example.restfull.common.IComController;
import com.example.restfull.common.IDaoExtend;
import com.example.restfull.model.SysUser;
import com.example.restfull.model.extend.PageModel;
import com.example.restfull.service.implserver.ImplServUser;
import com.example.restfull.tool.ToolObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/user")
public class CtrlUser implements IComController<SysUser>, IDaoExtend<SysUser>
{
    @Autowired
    private ImplServUser implServUser;

    /**
     * 添加不为空数据
     *
     * @param sysUser 实体
     * @return
     */
    @Override
    public ResponseEntity<?> add(SysUser sysUser)
    {
        implServUser.add(sysUser);
        return implServUser.returnResponseOK();
    }

    /**
     * 更新数据 按实体数据更新包括空
     *
     * @param sysUser 实体
     * @return
     */
    @Override
    public ResponseEntity<?> updateAll(SysUser sysUser)
    {
        implServUser.updateAll(sysUser);
        return implServUser.returnResponseOK();
    }

    /**
     * 更新数据 按实体数据非空值更新
     *
     * @param sysUser 实体
     * @return
     */
    @Override
    public ResponseEntity<?> updateNoNull(SysUser sysUser)
    {
        implServUser.updateNoNull(sysUser);
        return implServUser.returnResponseOK();
    }

    /**
     * 删除数据
     *
     * @param id id
     * @return
     */
    @Override
    public ResponseEntity<?> delete(Integer id)
    {
        implServUser.delete(id);
        return implServUser.returnResponseOK();
    }

    /**
     * 查询多条数据 无条件为全部数据
     *
     * @param sysUser 实体
     * @return
     */
    @Override
    public ResponseEntity<?> selectList(SysUser sysUser)
    {
        implServUser.selectList(sysUser);
        return implServUser.returnResponseOK();
    }


    /**
     * 分页公共接口
     *
     * @param pageModel 分页参数
     * @return PageInfo
     */
    @RequestMapping(value = "/page")
    public ResponseEntity<?> selectPage(@RequestBody PageModel<SysUser> pageModel)
    {
        implServUser.selectPage(pageModel);
        return implServUser.returnResponseOK();
    }

    /**
     * 批量删除
     *
     * @param ids id[]
     * @return num
     */
    public ResponseEntity<?> deleteIn(Integer[] ids)
    {
        implServUser.deleteIn(ids);
        return null;
    }
}

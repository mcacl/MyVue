package com.example.restfull.common;

import com.example.restfull.model.extend.PageModel;
import com.example.restfull.service.server.ImplIServComAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 * 创建时间:2019/8/28
 * 创建人:pmc
 * 描述:
 */
public abstract class ImplIComAbstract<T, F extends ImplIServComAbstract<T>> implements IComController<T>
{
    @Autowired
    public F fImplclass;

    /**
     * 添加不为空数据
     *
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public ResponseEntity<?> add(T t)
    {
        fImplclass.add(t);
        return fImplclass.returnResponseOK();
    }

    /**
     * 更新数据 按实体数据更新包括空
     *
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public ResponseEntity<?> updateAll(T t)
    {
        fImplclass.updateAll(t);
        return fImplclass.returnResponseOK();
    }

    /**
     * 更新数据 按实体数据非空值更新
     *
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public ResponseEntity<?> updateNoNull(T t)
    {
        fImplclass.updateNoNull(t);
        return fImplclass.returnResponseOK();
    }

    /**
     * 删除数据
     *
     * @param id 数据id
     * @return 影响行数
     */
    @Override
    public ResponseEntity<?> delete(int id)
    {
        fImplclass.delete(id);
        return fImplclass.returnResponseOK();
    }

    /**
     * 批量删除
     *
     * @param ids id[]
     * @return 影响行数
     */
    @Override
    public ResponseEntity<?> deleteIn(int[] ids)
    {
        fImplclass.deleteIn(ids);
        return fImplclass.returnResponseOK();
    }

    /**
     * 查询多条数据 无条件为全部数据
     *
     * @param t 实体
     * @return 数据集合
     */
    @Override
    public ResponseEntity<?> selectList(T t)
    {
        fImplclass.selectList(t);
        return fImplclass.returnResponseOK();
    }

    /**
     * 分页数据
     *
     * @param pageModel 分页实体
     * @return PageInfo
     */
    @Override
    public ResponseEntity<?> selectPage(PageModel<T> pageModel)
    {
        fImplclass.selectPage(pageModel);
        return fImplclass.returnResponseOK();
    }
}

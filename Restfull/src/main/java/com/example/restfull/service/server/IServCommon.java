package com.example.restfull.service.server;


import com.example.restfull.model.extend.PageModel;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 创建时间:2019/7/22
 * 创建人:pmc
 * 描述:
 */
public interface IServCommon<T>
{
    /**
     * 添加t
     *
     * @param t 表实体
     * @return 影响数目
     */
    int add(T t);

    /**
     * 更新t 全实体更新
     *
     * @param t 表实体
     * @return 影响数目
     */
    int updateAll(T t);

    /**
     * 更新t 非空实体数据更新
     *
     * @param t 表实体
     * @return 影响数目
     */
    int updateNoNull(T t);

    /**
     * 删除数据
     *
     * @param id 主键值
     * @return 影响数目
     */
    int delete(Integer id);

    /**
     * 删除数据批量
     *
     * @param ids 主键值数组
     * @return 影响数目
     */
    int deleteIn(int[] ids);

    /**
     * 更据主键查询实体
     *
     * @param t 实体
     * @return 实体
     */
    T selectKey(T t);

    /**
     * 更据主键查询实体
     *
     * @param key 实体
     * @return 实体
     */
    T selectKey(String key);

    /**
     * 更据实体条件查询数据
     *
     * @param t 实体
     * @return list<t>
     */
    List<T> selectList(T t);

    /**
     * 更据实体条件查询第一条数据 无数据返回null
     *
     * @param t 实体
     * @return t
     */
    default T selectFirstOrNull(T t)
    {
        List<T> list = selectList(t);
        if (list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }

    /**
     * 查询分页数据
     *
     * @param pageModel 分页实体
     * @return PageInfo 分页后对象
     */
    PageInfo selectPage(PageModel<T> pageModel);

    /**
     * 获取页面交互数据
     *
     * @return ResponseEntity<t>
     */
    ResponseEntity<?> returnResponseOK();
}

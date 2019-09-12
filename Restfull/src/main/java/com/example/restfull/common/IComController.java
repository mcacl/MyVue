package com.example.restfull.common;

import com.example.restfull.model.extend.PageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:公共控制器访问接口
 */
public interface IComController<T>
{
    /**
     * 添加不为空数据
     *
     * @param t 实体
     * @return 影响行数
     */
    @RequestMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody T t);

    /**
     * 更新数据 按实体数据更新包括空
     *
     * @param t 实体
     * @return 影响行数
     */
    @RequestMapping(value = "/updateall")
    public ResponseEntity<?> updateAll(@RequestBody T t);

    /**
     * 更新数据 按实体数据非空值更新
     *
     * @param t 实体
     * @return 影响行数
     */
    @RequestMapping(value = "/updatenonull")
    public ResponseEntity<?> updateNoNull(@RequestBody T t);

    /**
     * 删除数据
     *
     * @param id 数据id
     * @return 影响行数
     */
    @RequestMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestParam int id);

    /**
     * 批量删除
     *
     * @param ids id[]
     * @return 影响行数
     */
    @RequestMapping(value = "/deletein")
    ResponseEntity<?> deleteIn(@RequestBody int[] ids);

    /**
     * 更据主键查询实体
     *
     * @param t 实体
     * @return 实体
     */
    @RequestMapping(value = "/key")
    public ResponseEntity<?> selectKey(T t);

    /**
     * 查询多条数据 无条件为全部数据
     *
     * @param t 实体
     * @return 数据集合
     */
    @RequestMapping(value = "/list")
    public ResponseEntity<?> selectList(@RequestBody(required = false) T t);

    /**
     * 分页数据
     *
     * @param pageModel 分页实体
     * @return PageInfo
     */
    @RequestMapping(value = "/page")
    ResponseEntity<?> selectPage(@RequestBody PageModel<T> pageModel);
}

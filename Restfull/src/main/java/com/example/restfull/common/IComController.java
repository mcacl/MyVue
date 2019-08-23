package com.example.restfull.common;

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
     * @return
     */
    @RequestMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody T t);

    /**
     * 更新数据 按实体数据更新包括空
     *
     * @param t 实体
     * @return
     */
    @RequestMapping(value = "/updateall")
    public ResponseEntity<?> updateAll(@RequestBody T t);

    /**
     * 更新数据 按实体数据非空值更新
     *
     * @param t 实体
     * @return
     */
    @RequestMapping(value = "/updatenonull")
    public ResponseEntity<?> updateNoNull(@RequestBody T t);

    /**
     * 删除数据
     *
     * @param id 数据id
     * @return
     */
    @RequestMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id);

    /**
     * 查询多条数据 无条件为全部数据
     *
     * @param t 实体
     * @return
     */
    @RequestMapping(value = "/list")
    public ResponseEntity<?> selectList(@RequestBody(required = false) T t);
}

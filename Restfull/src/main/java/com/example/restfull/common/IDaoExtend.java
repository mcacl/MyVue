package com.example.restfull.common;

import com.example.restfull.model.extend.PageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建时间:2019/8/21
 * 创建人:pmc
 * 描述:dao 扩展接口
 */
public interface IDaoExtend<T>
{
    /**
     * 分页公共接口
     *
     * @param pageModel 分页实体
     * @return PageInfo
     */
    @RequestMapping(value = "/page")
    ResponseEntity<?> selectPage(@RequestBody PageModel<T> pageModel);

    /**
     * 批量删除
     *
     * @param ids id[]
     * @return num
     */
    @RequestMapping(value = "/deletein")
    ResponseEntity<?> deleteIn(@RequestBody Integer[] ids);
}
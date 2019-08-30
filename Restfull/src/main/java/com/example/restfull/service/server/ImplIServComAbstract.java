package com.example.restfull.service.server;

import com.example.restfull.common.ComReturn;
import com.example.restfull.model.extend.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/8/7
 * 创建人:pmc
 * 描述:
 */
public abstract class ImplIServComAbstract<T> implements IServCommon<T>
{
    /**
     * 公用页面返回对象
     */
    protected Object comResponseEntity = null;

    /**
     * 分页公共接口
     *
     * @param pageModel 当前页
     * @return PageInfo
     */
    @Override
    public PageInfo selectPage(PageModel<T> pageModel)
    {
        PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());//开始分页对象必须使用 否则可能会有错误
        List<T> list = selectList(pageModel.getT());
        PageInfo pageInfo = new PageInfo(list);
        comResponseEntity = pageInfo;
        return pageInfo;
    }

    public ResponseEntity<?> returnResponseOK()
    {
        return ComReturn.responseReturnOK(comResponseEntity);
    }
}

package com.example.restfull.model.extend;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建时间:2019/8/23
 * 创建人:pmc
 * 描述:
 */
public class PageModel<T>
{
    private Integer pageNum = 1;
    private Integer pageSize = 20;
    private T model;

    public Integer getPageNum()
    {
        return pageNum;
    }

    @JsonProperty(value = "pageNum")
    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    @JsonProperty(value = "pageSize")
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public T getT()
    {
        return model;
    }

    @JsonProperty(value = "model")
    public void setT(T model)
    {
        this.model = model;
    }
}

package com.example.restfull.model;

import java.util.Date;

public class SysMenu
{
    private Integer menuid;

    private String name;

    private String component;

    private String icon;

    private Integer pid;

    private Integer sort;

    private Date time;

    private Integer userid;
    private Integer enable;
    private String data;

    public SysMenu(Integer menuid, String name, String component, String icon, Integer pid, Integer sort, Date time, Integer userid, Integer enable, String data)
    {
        this.menuid = menuid;
        this.name = name;
        this.component = component;
        this.icon = icon;
        this.pid = pid;
        this.sort = sort;
        this.time = time;
        this.userid = userid;
        this.enable = enable;
        this.data = data;
    }

    public SysMenu()
    {
        super();
    }

    public Integer getMenuid()
    {
        return menuid;
    }

    public void setMenuid(Integer menuid)
    {
        this.menuid = menuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public String getComponent()
    {
        return component;
    }

    public void setComponent(String component)
    {
        this.component = component == null ? null : component.trim();
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getPid()
    {
        return pid;
    }

    public void setPid(Integer pid)
    {
        this.pid = pid;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public Integer getEnable()
    {
        return enable;
    }

    public void setEnable(Integer enable)
    {
        this.enable = enable;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
}
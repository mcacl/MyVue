package com.example.restfull.model;

import java.util.Date;

public class SysUserGroup
{
    private Integer groupid;

    private String groupname;

    private String menuid;

    private Date createtime;

    private Integer isuse;

    public SysUserGroup(Integer groupid, String groupname, String menuid, Date createtime, Integer isuse)
    {
        this.groupid = groupid;
        this.groupname = groupname;
        this.menuid = menuid;
        this.createtime = createtime;
        this.isuse = isuse;
    }

    public SysUserGroup()
    {
        super();
    }

    public Integer getGroupid()
    {
        return groupid;
    }

    public void setGroupid(Integer groupid)
    {
        this.groupid = groupid;
    }

    public String getGroupname()
    {
        return groupname;
    }

    public void setGroupname(String groupname)
    {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getMenuid()
    {
        return menuid;
    }

    public void setMenuid(String menuid)
    {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Integer getIsuse()
    {
        return isuse;
    }

    public void setIsuse(Integer isuse)
    {
        this.isuse = isuse;
    }
}
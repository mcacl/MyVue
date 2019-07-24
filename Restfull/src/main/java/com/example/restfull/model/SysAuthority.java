package com.example.restfull.model;

public class SysAuthority {
    private Integer id;

    private Integer userid;

    private String menuid;

    private Integer groupid;

    public SysAuthority(Integer id, Integer userid, String menuid, Integer groupid) {
        this.id = id;
        this.userid = userid;
        this.menuid = menuid;
        this.groupid = groupid;
    }

    public SysAuthority() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}
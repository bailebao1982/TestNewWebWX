/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.bo;

import java.util.List;

/**
 *
 * @author wewezhu
 */
public class UserInfo {
    private long errcode;
    
    private String errmsg;
    
    private String userid;
    
    private String name;
    
    private long[] department;
    
    private String position;
    
    private String mobile;
    
    private String email;
    
    private String weixinid;
    
    private String avatar;
    
    private long status;
    
    private UserInfoExtraAttr extattr;

    public long getErrcode() {
        return errcode;
    }

    public void setErrcode(long errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long[] getDepartment() {
        return department;
    }

    public void setDepartment(long[] department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

   public UserInfoExtraAttr getExtattr() {
       return extattr;
   }

   public void setExtattr(UserInfoExtraAttr extattr) {
       this.extattr = extattr;
   }
    
    
    
}

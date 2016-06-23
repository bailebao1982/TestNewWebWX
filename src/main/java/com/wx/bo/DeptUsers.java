/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.bo;

/**
 *
 * @author wewezhu
 */
public class DeptUsers {
    private long errcode;
    
    private String errmsg;
    
    private DeptUser[] userlist;

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

    public DeptUser[] getUserlist() {
        return userlist;
    }

    public void setUserlist(DeptUser[] userlist) {
        this.userlist = userlist;
    }
    
    
}

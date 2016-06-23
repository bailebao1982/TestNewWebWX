/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.cli.message;

import com.wx.bo.UserInfo;
import java.util.Set;

/**
 *
 * @author wewezhu
 */
public class CheckCommandReturnMessage {
    private String content;
    
    private Set<UserInfo> userInfos;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(Set<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
    
    
}

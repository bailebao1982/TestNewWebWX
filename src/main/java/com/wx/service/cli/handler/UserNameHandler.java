/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.cli.handler;

import com.wx.bo.UserInfo;
import com.wx.service.impl.CoreService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wewezhu
 */
public class UserNameHandler {
    public static Set<UserInfo> getUserName(String command) throws Exception{
        Set<UserInfo> userInfos = new HashSet<UserInfo>();
        String[] useridList = command.split("@");
        for(String userid:useridList){
            if(userid.toUpperCase().equals("ALL")){
                //TODO add logic to get all users.
                
                break;
            }else if(!userid.equals("")){
                UserInfo userInfo = CoreService.getUserInfoFromUserID(userid);
                System.out.println("UserNameHandler.getUserid():"+userInfo.getUserid());
                System.out.println("UserNameHandler.getWeixinid():"+userInfo.getWeixinid());
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }
    
    public static void main(String[] args){
        String command = "@zhuwei8231";
        String[] useridList = command.split("@");
        for(String user:useridList){
            if(!user.equals("")){
                System.out.println(user);
            }
        }
    }
}

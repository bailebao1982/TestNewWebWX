/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import java.text.MessageFormat;

/**
 *
 * @author wewezhu
 */
public class QyWxURLUtil {
    
    /**
     * 
     */
    private static final String queryUserURL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={0}&userid={1}";
    private static final String msgSendURL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";
    private static final String uploadMediaURL = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token={0}&type={1}";
    
    private static final String createUserURL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token={0}";
    private static final String updateUserURL = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token={0}";
    private static final String deleteUserURL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token={0}&userid={1}";
    private static final String getUsreURL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={0}&userid={1}";

    public static String getQueryUserURL() {
        String accessToken = AccessTokenGen.GetToken();
        String url = queryUserURL;
        url = MessageFormat.format(url,accessToken);
        return url;
    }

    public static String getMsgSendURL() {
        String accessToken = AccessTokenGen.GetToken();
        String url = msgSendURL;
        url =  MessageFormat.format(url,accessToken);
        return url;
    }

    public static String getUploadMediaURL() {
        String accessToken = AccessTokenGen.GetToken();
        String url = uploadMediaURL;
        url = MessageFormat.format(url, accessToken);
        return url;
    }

    
    public static void main(String[] args){
        //System.out.println(MessageFormat.format(QyWxURLUtil.queryUserURL, "xxxxxxvvvv"));
        String query = MessageFormat.format(QyWxURLUtil.uploadMediaURL, "xxxxxxvvvv");
        query = MessageFormat.format(query, 0,"90");
        System.out.println(query);
    }
}

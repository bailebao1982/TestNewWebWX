/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import com.wx.corprcv.message.AccessTokenReturnMessage;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author wewezhu
 */
public class AccessTokenGen {
 
    private static String access_token;
    
    private static long expires_in=7200*1000;
    
    private static Date createTokenTime = new Date(System.currentTimeMillis());
    
    public static Date TokenOverdueTime(){
        
        long time = createTokenTime.getTime()+expires_in;
        Date overDueTime = new Date(time);
        return overDueTime;
    }
    
    private static void Renovate(){
        if(access_token == null){
            GetNewToken();
        }
        createTokenTime = new Date(System.currentTimeMillis());
    }
    
    private static boolean IsTimeOut(){
        if(access_token == null){
            GetNewToken();
        }
        
        return System.currentTimeMillis()> TokenOverdueTime().getTime();
    }
    
     private static void GetNewToken() {
        try {
            String corpid = "wxe706b25abb1216c0";
            
            String corpsecret = "fTv1Qt232xA17jQXcJm8PbmQyz5KQzR2JI7uRJSOj5HygMk2S_ayezlx1rnL0sUv";
            
            String accessRequestURL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret;
            
            String returnMessage = HttpUtil.httpGet(accessRequestURL);
            
            JSONObject returnJsonMsg = JSONObject.fromObject(returnMessage);
            
            AccessTokenReturnMessage accessTokenMsg = (AccessTokenReturnMessage) JSONObject.toBean(returnJsonMsg, AccessTokenReturnMessage.class);
            
            access_token = accessTokenMsg.getAccess_token();
        } catch (Exception ex) {
            Logger.getLogger(AccessTokenGen.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
    
     public static String GetToken(){
         if(access_token == null){
             System.out.println("GetToken firstTime while accessToken is null.");
             Renovate();
             System.out.println("accessToken:"+access_token);
         }else if(IsTimeOut()){
             System.out.println("GetToken while timeout.");
             GetNewToken();
             createTokenTime = new Date(System.currentTimeMillis());
             System.out.println("acessToken:"+access_token);
         }
         
         return access_token;
     }
     
     public static void main(String[] args){
         System.out.println(new Date(System.currentTimeMillis()));
         System.out.println(TokenOverdueTime());
     }
    
    
}

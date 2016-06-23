/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.corprcv.message;

import net.sf.json.JSONObject;

/**
 *
 * @author wewezhu
 */
public class AccessTokenReturnMessage {
    private String errcode;
    
    private String errmsg;
    
    private String access_token;
    
    private int expires_in;
    
    private String invalidtag;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getInvalidtag() {
        return invalidtag;
    }

    public void setInvalidtag(String invalidtag) {
        this.invalidtag = invalidtag;
    }
    
    
    
    public static void main(String args[]){
        String correctmsg = "{\"access_token\":\"hB7UIN5hSvS3PB_NpHJ0abrE5ohHrmQtxpiBxEPZoy6MHKHMj6iRB0qmVm157zjA\",\"expires_in\":7200}";
        JSONObject jsonObj1 = JSONObject.fromObject(correctmsg);
        
        AccessTokenReturnMessage p2 = (AccessTokenReturnMessage)JSONObject.toBean(jsonObj1, AccessTokenReturnMessage.class);  
        
        System.out.println(p2.getErrcode());
        System.out.println(p2.getErrmsg());
        System.out.println(p2.getAccess_token());
        System.out.println(p2.getExpires_in());
         System.out.println(p2.getInvalidtag());
    }
    
}

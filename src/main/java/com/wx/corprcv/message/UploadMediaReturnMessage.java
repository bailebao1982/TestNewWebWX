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
public class UploadMediaReturnMessage {
     private String errcode;
    
    private String errmsg;
    
    private String type;
    
    private String media_id;
    
    private String created_at;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
     public static void main(String args[]){
        String correctmsg = "{\n" +
"   \"type\": \"image\",\n" +
"   \"media_id\": \"0000001\",\n" +
"   \"created_at\": \"1380000000\"\n" +
"}";
        JSONObject jsonObj1 = JSONObject.fromObject(correctmsg);
        
        UploadMediaReturnMessage p2 = (UploadMediaReturnMessage)JSONObject.toBean(jsonObj1, UploadMediaReturnMessage.class);  
        
        System.out.println(p2.getErrcode());
        System.out.println(p2.getErrmsg());
        System.out.println(p2.getMedia_id());
        System.out.println(p2.getCreated_at());
        System.out.println(p2.getType());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.corpsend.message;

import net.sf.json.JSONObject;

/**
 *
 * @author wewezhu
 */
public class JsonTest {
    
    public static void main(String arg[]){
        TextSendMessage textMsg = new TextSendMessage();
        textMsg.setTextContent("this is test message");
        textMsg.setMsgtype("text");
        textMsg.setTouser("zhuwei8231");
        textMsg.setAgentid(1);
        
        JSONObject jobj=JSONObject.fromObject(textMsg);
        System.out.println(jobj.toString());
    }
}

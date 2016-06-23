/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.corpsend.message;

/**
 *
 * @author wewezhu
 */
public class CorpSendBase {
     // UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送  
    private String touser;  
    // PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数  
    private String toparty;  
    // TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数  
    private long totag;  
    // 消息类型（text/image/location/link）  
    private String msgtype;  
    // 企业应用的id，整型。可在应用的设置页面查看 
    private long agentid;  

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public long getTotag() {
        return totag;
    }

    public void setTotag(long totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public long getAgentid() {
        return agentid;
    }

    public void setAgentid(long agentid) {
        this.agentid = agentid;
    }

  
}

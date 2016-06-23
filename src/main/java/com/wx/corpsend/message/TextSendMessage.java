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
public class TextSendMessage extends CorpSendBase{
   private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
   
   public void setTextContent(String txt){
       text = new Text();
       text.setContent(txt);
   }
    
    
}

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
public class ImageSendMessage extends CorpSendBase{
    
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public void setImageMedia(String mediaId){
        image = new Image();
        image.setMedia_id(mediaId);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.entity;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;  
import javax.persistence.GeneratedValue; 
import javax.persistence.Lob;
/**
 *
 * @author wewezhu
 */
@Entity
@Table(name="T_Customer")
public class Customer {
    
    @Id  
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")  
    @Column(length=32)
    private String id;
    
    @Column(length=32)
    private String name;
    
    @Column(length=32)
    private String type;
    
    @Column(length=32)
    private String coacherId;
    
    @Column(name="image")
    @Lob
    private Blob image;
    
    @Column(length=32)
    private String address;
    
    @Column(length=32)
    private String mobile;
    
    @Column(length=32)
    private String job;
    
    @Column(length=32)
    private String weixinId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }
    
    

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoacherId() {
        return coacherId;
    }

    public void setCoacherId(String coacherId) {
        this.coacherId = coacherId;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;  
import javax.persistence.GeneratedValue; 
/**
 *
 * @author wewezhu
 */
@Entity
@Table(name="T_Sign")
public class Sign {
    @Id  
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")  
    @Column(length=32)
    private String id;
    
    @Column(length=32)
    private String coacherId;
    
    @Column(length=32)
    private String customerId;
    
    @Column
    private Date ClassTime;
    
    @Column(length=280)
    private String feedback;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoacherId() {
        return coacherId;
    }

    public void setCoacherId(String coacherId) {
        this.coacherId = coacherId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getClassTime() {
        return ClassTime;
    }

    public void setClassTime(Date ClassTime) {
        this.ClassTime = ClassTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
}

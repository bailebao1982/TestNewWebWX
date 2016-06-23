/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author wewezhu
 */
@Entity
@Table(name="T_RegisterClass")
public class RegisterClass {
    @Id  
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")  
    @Column(length=32)
    private String id;
     
    @Column(length=32)
    private String Coacher;
    
    @Column(length=32)
    private String Customer;
     
    @Column(length=32)
    private String place;
     
     @Column
    private Date classTime;
     
     @Column
     private Time time;
     
     @Column(length=60)
     private String Signature;
     
     @Column
     private boolean deleteFlag;
     
     @Column(length=32)
    private String ClassType;

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }    
     
    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
     
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoacher() {
        return Coacher;
    }

    public void setCoacher(String Coacher) {
        this.Coacher = Coacher;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getClassType() {
        return ClassType;
    }

    public void setClassType(String ClassType) {
        this.ClassType = ClassType;
    }
  
     
}

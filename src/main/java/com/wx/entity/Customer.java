/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.entity;
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

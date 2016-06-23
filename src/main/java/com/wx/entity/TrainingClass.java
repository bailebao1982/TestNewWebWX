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
@Table(name="T_TrainingClass")
public class TrainingClass {
    
    @Id  
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")  
    @Column(length=32)
    private String id;
    
    @Column(length=32)
    private String Coacher_ID;
    
    @Column(length=32)
    private String Customer_ID;
    
    @Column
    private Date classTime;
    
    @Column(length=280)
    private String trainingPlan;
    
    @Column
    private boolean schedule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoacher_ID() {
        return Coacher_ID;
    }

    public void setCoacher_ID(String Coacher_ID) {
        this.Coacher_ID = Coacher_ID;
    }

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public boolean isSchedule() {
        return schedule;
    }

    public void setSchedule(boolean schedule) {
        this.schedule = schedule;
    }
    
    
}

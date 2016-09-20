/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author wewezhu
 */
@Entity
@Table(name="T_SaleRecord")
public class SalesRecord {
    @Id  
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")  
    @Column(length=32)
    private String id;
    
    @Column(length=32)
    private String Coacher;
    
    @Column(length=32)
    private String Customer;
    
    @Column
    private int classNum;
    
    @Column(length=32)
    private String ClassType;
    
    @Column
    private Date SalesTime;
    

    
     @Column
     private Date StartDate;
     
     @Column
     private int UnitPrice;

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }


    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int UnitPrice) {
        this.UnitPrice = UnitPrice;
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

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getClassType() {
        return ClassType;
    }

    public void setClassType(String ClassType) {
        this.ClassType = ClassType;
    }

    public Date getSalesTime() {
        return SalesTime;
    }

    public void setSalesTime(Date SalesTime) {
        this.SalesTime = SalesTime;
    }

    
    
}

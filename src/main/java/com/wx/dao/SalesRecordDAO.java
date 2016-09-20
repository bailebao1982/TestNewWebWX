/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

import com.wx.entity.CustomerGroup;
import com.wx.entity.SalesRecord;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface SalesRecordDAO {
    List<SalesRecord> findSalesRecordByCustomer(String customer);
    
    int findGroupSalesRecordByCustomer(String customr,String classType);
    
    SalesRecord findSalesRecordById(String id);
    
    void addSalesRecord(String customerName,String classType,String coacherName,String unitPrice,Date salesDate,Date startDate,CustomerGroup customerGroup);
 
}

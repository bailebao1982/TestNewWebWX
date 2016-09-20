/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service;

import com.wx.entity.SalesRecord;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface SalesService {
    List<SalesRecord> getAllSalesRecordsByCustomer(String CustomerId);
    
    SalesRecord findSalesRecordById(String id);
}

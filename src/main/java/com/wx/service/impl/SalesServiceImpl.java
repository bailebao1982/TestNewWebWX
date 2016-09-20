/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.impl;

import com.wx.dao.SalesRecordDAO;
import com.wx.entity.SalesRecord;
import com.wx.service.SalesService;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public class SalesServiceImpl implements SalesService{
    private SalesRecordDAO  salesRecordDAO;
    
    
    public List<SalesRecord> getAllSalesRecordsByCustomer(String CustomerId){
        
        return salesRecordDAO.findSalesRecordByCustomer(CustomerId);
    }

    public SalesRecordDAO getSalesRecordDAO() {
        return salesRecordDAO;
    }

    public void setSalesRecordDAO(SalesRecordDAO salesRecordDAO) {
        this.salesRecordDAO = salesRecordDAO;
    }

    @Override
    public SalesRecord findSalesRecordById(String id) {
        return salesRecordDAO.findSalesRecordById(id);
    }
    
    
}

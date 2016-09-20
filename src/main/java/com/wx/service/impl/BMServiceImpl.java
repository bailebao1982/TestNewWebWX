/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.impl;

import com.wx.dao.BmDAO;
import com.wx.entity.BM;
import com.wx.service.BMService;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public class BMServiceImpl implements BMService{

    private BmDAO bmDAO;
    
    @Override
    public List<BM> getAllBMByCustomerId(String customerId) {
        return bmDAO.getAllBMsByCustomerId(customerId);
    }

    public BmDAO getBmDAO() {
        return bmDAO;
    }

    public void setBmDAO(BmDAO bmDAO) {
        this.bmDAO = bmDAO;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service;

import com.wx.entity.BM;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface BMService {
    public List<BM> getAllBMByCustomerId(String customerId);
}

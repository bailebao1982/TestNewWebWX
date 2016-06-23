/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

import com.wx.entity.RegisterClass;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface RegisterClassDAO {
    RegisterClass addRegisterClass(RegisterClass regClass);
    
    List<RegisterClass> findRegisterClassByCustomer(String customer);
    
    RegisterClass findRegisterClassBySignature(String signature);
    
    void deleteRegisterClassBySignature(String signature);
   
    int queryRegisterClassWithCurrentWeek(String customer, Date startDate,String classType);
    
    int queryRegisterClassWithCurrentMonth(String customer, Date startDate,String classType);
    
     int queryRegisterClassWithCurrentYear(String customer, Date startDate);
     
     int queryAllRegisterClassByCustomer(String customer,String classType);
}

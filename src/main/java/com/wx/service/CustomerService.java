/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service;

import com.wx.entity.Customer;
import com.wx.entity.CustomerGroup;
import com.wx.entity.SalesRecord;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface CustomerService {
    
    boolean addNewCustomer(Customer customer);
    
    boolean removeCustomer(Customer customer);
    
    List<Customer> getAllCustomer();
    
    Customer getCustomerByName(String name);
    
    boolean updateCustomer(Customer customer);
    
    boolean addOOSalesRecord(SalesRecord salRec);
    
    boolean addOMSalesRecord(SalesRecord salRec,CustomerGroup cg);
    
    
    
}

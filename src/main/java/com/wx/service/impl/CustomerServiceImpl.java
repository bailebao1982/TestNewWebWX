/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.impl;

import com.wx.corprcv.message.AccessTokenReturnMessage;
import com.wx.corpsend.addressbook.message.CustomerMsgBase;
import com.wx.dao.CustomerDAO;
import com.wx.dao.CustomerGroupDAO;
import com.wx.dao.SalesRecordDAO;
import com.wx.dao.impl.CustomerDAOImpl;
import com.wx.entity.Customer;
import com.wx.entity.CustomerGroup;
import com.wx.entity.SalesRecord;
import com.wx.service.CustomerService;
import com.wx.util.QyWxURLUtil;
import com.wx.util.WXMsgUtil;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public class CustomerServiceImpl implements CustomerService{
    
    private CustomerDAO customerDAO;
    
    private SalesRecordDAO  salesRecordDAO;
    
    private CustomerGroupDAO customerGroupDAO;
    
    @Override
    public boolean addNewCustomer(Customer customer) {
       CustomerMsgBase msg = new CustomerMsgBase();
       
       msg.setName(customer.getName());
       msg.setDepartment(customer.getDepartment());
       msg.setEmail(customer.getEmail());
       msg.setGender(customer.getGender());
       msg.setMobile(customer.getMobile());
       msg.setPosition(customer.getUserid());
       msg.setUserid(customer.getUserid());
       msg.setWeixinid(customer.getWeixinid());
       
       
       
       AccessTokenReturnMessage returnMsg = WXMsgUtil.sendMessage(msg,QyWxURLUtil.getCreateUserURL());
       
       if(("0".equals(returnMsg.getErrcode()))&&("created".equals(returnMsg.getErrmsg()))){
            Customer newCustomer =  customerDAO.addCustomer(customer);
            return true;
       }else{
           return false;
       }
    }

    @Override
    public boolean removeCustomer(Customer customer) {
       CustomerMsgBase msg = new CustomerMsgBase();
       msg.setName(customer.getName());
       AccessTokenReturnMessage returnMsg = WXMsgUtil.sendMessage(msg,QyWxURLUtil.getDeleteUserURL());
       
       if(("0".equals(returnMsg.getErrcode()))&&("deleted".equals(returnMsg.getErrmsg()))){
     
           return customerDAO.removeCustomer(customer);
       }else{
           return false;
       }
    }

    @Override
    public List<Customer> getAllCustomer() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerByName(String name) {
       
        return customerDAO.findCustomerByName(name);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        
        return false;
    }

    @Override
    public boolean addOOSalesRecord(SalesRecord salRec) {
        
        salRec.setClassType("OO");
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOMSalesRecord(SalesRecord salRec, CustomerGroup cg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

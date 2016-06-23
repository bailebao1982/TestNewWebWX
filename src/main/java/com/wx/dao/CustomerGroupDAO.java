/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

/**
 *
 * @author wewezhu
 */
public interface CustomerGroupDAO {
    String findCustomerGroupNameByCustomerName(String Name);
    
    String[] findCustomersByCustomerGroupName(String GroupName);
    
}

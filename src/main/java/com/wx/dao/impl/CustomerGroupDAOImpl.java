/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;

import com.wx.dao.CustomerGroupDAO;
import com.wx.entity.CustomerGroup;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class CustomerGroupDAOImpl implements CustomerGroupDAO{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public String findCustomerGroupNameByCustomerName(String Name) {
        String hql = "from CustomerGroup as customerGroup where customerGroup.CustomerName = '"+Name+"'";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        CustomerGroup cg = (CustomerGroup)result;
        return cg.getGroupName();
    }

    @Override
    public String[] findCustomersByCustomerGroupName(String GroupName) {
         String hql = "from CustomerGroup as cg where cg.GroupName = '"+GroupName+"'"; 
         Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        //query.setString("GroupName", GroupName);
        //System.out.println("GroupName.Parameter:"+GroupName);
        List<CustomerGroup> list = query.list();
        
        String[] returnVals = new String[list.size()];
        
        int index = 0;
        for(CustomerGroup cg:list){
            //System.out.println("cg.getCustomerName:"+cg.getCustomerName());
            returnVals[index]=cg.getCustomerName();
            index++;
        }
        
        return returnVals;
    }
    
}

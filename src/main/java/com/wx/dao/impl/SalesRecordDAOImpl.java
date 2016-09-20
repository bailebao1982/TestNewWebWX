/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;

import com.wx.dao.SalesRecordDAO;
import com.wx.entity.Customer;
import com.wx.entity.CustomerGroup;
import com.wx.entity.SalesRecord;
import java.sql.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class SalesRecordDAOImpl implements SalesRecordDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<SalesRecord> findSalesRecordByCustomer(String customer) {
         String hql = "from SalesRecord as salesRecord where salesRecord.Customer = :customer"; 
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        query.setString("customer", customer);
        List<SalesRecord> list = query.list();
        
        return list;
    }
    
     @Override
        public int findGroupSalesRecordByCustomer(String customer,String classType){
            String hql = "select sum(salesRecord.classNum) as classNum from SalesRecord as salesRecord where salesRecord.Customer = :customer and salesRecord.ClassType =:ClassType group by Customer"; 
        
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            //query.uniqueResult()
            query.setString("customer", customer);
            query.setString("ClassType",classType);
            Object returnResult = query.uniqueResult();
            System.out.println("returnResult:"+returnResult);
           
            return  Integer.parseInt(returnResult.toString());
        }
    
     @Override
        public void addSalesRecord(String customerName,String classType,String coacherName,String unitPrice,Date salesDate,Date startDate,CustomerGroup customerGroup){
            
        }

    @Override
    public SalesRecord findSalesRecordById(String id) {
        String hql = "from SalesRecord as saleRec where saleRec.id = :id"; 
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        query.setString("id", id);
        List<SalesRecord> list = query.list();
        
        return list.get(0);
    }
}

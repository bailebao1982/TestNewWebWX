/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;


import com.wx.dao.CustomerDAO;
import com.wx.entity.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class CustomerDAOImpl implements CustomerDAO {
    
      private Session session;
      
     private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public Customer addCustomer(Customer customer){
        session.save(customer);
        return customer;
    }
    
    @Override
    public Customer updateCustomer(Customer customer){
        session.update(customer);
        return customer;
    }
    
    @Override
    public boolean removeCustomer(Customer customer){
        session.delete(customer);
        return true;
    }
    
    @Override
    public Customer findCustomerById(String customerId){
        
        String hql = "from Customer as customer where customer.id = :id"; 
        Query query = session.createQuery(hql);
        
        query.setString("id", customerId);
        List<Customer> list = query.list();
        
        return list.get(0);
    }
    
    @Override
    public Customer findCustomerByName(String name){
        String hql = "from Customer as customer where customer.name = :name"; 
        Query query = session.createQuery(hql);
        
        query.setString("name", name);
        List<Customer> list = query.list();
        
        return list.get(0);
    }
    
}

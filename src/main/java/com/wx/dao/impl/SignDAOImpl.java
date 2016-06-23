/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;


import com.wx.dao.SignDAO;
import com.wx.entity.Sign;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class SignDAOImpl implements SignDAO {
  
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
    public Sign addSign(Sign sign){
        session.save(sign);
        return sign;
    }
    
    @Override
    public Sign updateSign(Sign sign){
        session.update(sign);
        return sign;
    }
    
    @Override
    public boolean removeSign(Sign sign){
        session.delete(sign);
        return true;
    }
    
    @Override
    public Sign findSignById(Long id){
        String hql = "from Sign as sign where sign.id = :id"; 
        Query query = session.createQuery(hql);
        
        query.setLong("id", id);
        List<Sign> list = query.list();
        
        return list.get(0);
    }
    
    @Override
    public List<Sign> findSignByCustomerId(Long customerId){
        String hql = "from Sign as sign where sign.customerId = :customerId"; 
        Query query = session.createQuery(hql);
        
        query.setLong("customerId", customerId);
        List<Sign> list = query.list();
        
        return list;
    }
    
    @Override
    public List<Sign> findSignByCoacherId(Long coacherId){
         String hql = "from Sign as sign where sign.coacherId = :coacherId"; 
        Query query = session.createQuery(hql);
        
        query.setLong("coacherId", coacherId);
        List<Sign> list = query.list();
        
        return list;
    }
    
    
}

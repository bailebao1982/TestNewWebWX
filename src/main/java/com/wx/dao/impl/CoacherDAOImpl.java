/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;



import com.wx.dao.CoacherDAO;
import com.wx.entity.Coacher;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author wewezhu
 */
public class CoacherDAOImpl implements CoacherDAO {
    
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
    public Coacher addCoacher(Coacher coacher){
        session.save(coacher);
        return coacher;
    }
    
    @Override
    public boolean reomveCoacher(Coacher coacher){
        session.delete(coacher);
        return true;
    }
    
    @Override
    public Coacher updateCoacher(Coacher coacher){
        session.update(coacher);
        return coacher;
    }
    
    @Override
    public Coacher findCoaherById(String id){
       
        String hql = "from Coacher as coacher where coacher.id = :id"; 
        Query query = session.createQuery(hql);
        
        query.setString("id", id);
        List<Coacher> list = query.list();
        
        return list.get(0);
    }
    
    @Override
    public Coacher findCoacherByName(String name){
        String hql = "from Coacher as coacher where coacher.name = :name"; 
        Query query = session.createQuery(hql);
        
        query.setString("name", name);
        List<Coacher> list = query.list();
        
        return list.get(0);
    }
    
    
}

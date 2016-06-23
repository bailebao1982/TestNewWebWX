/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;


import com.wx.dao.TrainingClassDAO;
import com.wx.entity.TrainingClass;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class TrainingClassDAOImpl implements TrainingClassDAO {
    
     private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public TrainingClass addTrainingClass(TrainingClass trainingClass){
        System.out.println("Enter DAO.addTrainingClass");
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(trainingClass);
       
        return trainingClass;
    }
    
    @Override
    public TrainingClass updateTrainingClass(TrainingClass trainingClass){
        
        return null;
    }
    
    @Override
    public boolean removeTrainingClass(TrainingClass trainingClass){
        
        return false;
    }
    
    @Override
    public TrainingClass findTrainingClassById(Long classId){
        
        return null;
    }
    
    @Override
    public List<TrainingClass> findTrainingClassByCoacher(Long coacherId){
        
        return null;
    }
    
    @Override
    public List<TrainingClass> findTrainingClassByCustomer(Long customerId){
        
        return null;
    }
}

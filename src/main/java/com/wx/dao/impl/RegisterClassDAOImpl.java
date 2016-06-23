/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao.impl;

import com.wx.dao.RegisterClassDAO;
import com.wx.entity.RegisterClass;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class RegisterClassDAOImpl implements RegisterClassDAO{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public RegisterClass addRegisterClass(RegisterClass regClass) {
        sessionFactory.getCurrentSession().saveOrUpdate(regClass);
        return regClass;
    }

    @Override
    public List<RegisterClass> findRegisterClassByCustomer(String customer) {
       
        return null;
    }

    
    @Override
    public int queryRegisterClassWithCurrentWeek(String customer, Date startDate,String classType){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and YEARWEEK(date_format('"+beginDateStr+"','%Y-%m-%d')) = YEARWEEK(classTime) and Customer = '"+customer+"' and ClassType = '"+classType+"'";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
       
    }
    
    @Override
    public int queryRegisterClassWithCurrentMonth(String customer, Date startDate,String classType){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and month(date_format('"+beginDateStr+"','%Y-%m-%d')) = month(classTime) and Customer='"+customer+"' and ClassType = '"+classType+"'";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
    @Override
    public int queryRegisterClassWithCurrentYear(String customer, Date startDate){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and year(date_format('"+beginDateStr+"','%Y-%m-%d')) = year(classTime) and Customer='"+customer+"'";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
    public RegisterClass findRegisterClassBySignature(String signature){
        String hql = "from RegisterClass where Signature = '"+signature+"'";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return (RegisterClass)result;
    }
    
    public void deleteRegisterClassBySignature(String signature){
        RegisterClass registerClass = findRegisterClassBySignature(signature);
        registerClass.setDeleteFlag(true);
        sessionFactory.getCurrentSession().update(registerClass);
        
        
    }

    @Override
    public int queryAllRegisterClassByCustomer(String customer,String classType) {
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and Customer='"+customer+"' and classType = '"+classType+"' group by Customer";
        Object result = sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
}

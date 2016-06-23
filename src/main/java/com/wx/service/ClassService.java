/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service;

import com.wx.entity.RegisterClass;
import java.sql.Date;
import java.sql.Time;




/**
 *
 * @author wewezhu
 */
public interface ClassService {

    /**
     * 接受约课信息
     * @param coacherId
     * @param customerId
     * @param time
     * @return
     */
    boolean acceptAppointment(String coacherId, String customerId, Date time);

    /**
     * 教练取消预约课程
     * @param coacherId
     * @param appointmentId
     * @return
     */
    boolean cancelAppointmentFromCoacher(Long coacherId, Long appointmentId);

    /**
     * 会员取消预约课程
     * @param customerId
     * @param appointmentId
     * @return
     */
    boolean cancelAppointmentFromCustomer(Long customerId, Long appointmentId);

    /**
     * 会员签课
     * @param customerId
     * @param coacherId
     * @param appointmentId
     * @return
     */
    boolean checkinClass(Long customerId, Long coacherId, Long appointmentId);

    /**
     * 拒绝约课信息，提供拒绝理由
     * @param coacherId
     * @param customerId
     * @param time
     * @param reason
     * @return
     */
    boolean denyAppointment(Long coacherId, Long customerId, Date time, String reason);

    /**
     * 发起一个约课信息信息
     * @param coacherId
     * @param customerId
     * @param time
     * @return
     */
    boolean newAppointment(String coacherId, String customerId, Date time);

    /**
     * 增加一个会员信息
     *
     * @param coacherId
     * @param customerId
     * @return
     */
    boolean newCustomer(String coacherId, String customerId);

    /**
     * 重排约课时间
     * @param apponitmentId
     * @param newTime
     * @return
     */
    boolean resheduleAppointment(Long apponitmentId, Date newTime);
    
    /**
     * 签课
     * @param coacher
     * @param customer
     * @param time
     * @return 
     */
    boolean registerClass(String classType,String coacher, String customer, Date time,Time hourTime,String place,String signature);
    
    /**
     * Search Register Class
     * @param signature
     * @return 
     */
    RegisterClass findRegisterClassBySignature(String signature);
    
    /**
     * Delete register class.
     * @param signature 
     */
    void deleteRegisterClassBySignature(String signature);
    /**
     * 统计最近一周上课次数
     * @param coacher
     * @param currentTime
     * @return 
     */
    int counterRegisterClassByNameRecentWeek(String coacher, Date currentTime,String classType);
    
    /**
     * 统计最近一个月上课次数
     * @param coacher
     * @param currentTime
     * @return 
     */
    int counterRegisterClassByNameRecentMonth(String coacher,Date currentTime,String classType);
    
    
    /**
     * 统计最近一年上课次数
     * @param coacher
     * @param currentTime
     * @return 
     */
    int counterRegisterClassByNameRecentYear(String coacher,Date currentTime);
    
    int getCustomerAllRegisterClass(String customer,String classType);
    
    int getSalesRecordNumByCustomer(String customer,String classType);
    
    String findCustomerGroupNameByCustomerName(String Name);
    
    String[] findCustomersByCustomerGroupName(String GroupName);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

import com.wx.entity.Sign;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface SignDAO {

    Sign addSign(Sign sign);

    List<Sign> findSignByCoacherId(Long coacherId);

    List<Sign> findSignByCustomerId(Long customerId);

    Sign findSignById(Long id);

    boolean removeSign(Sign sign);

    Sign updateSign(Sign sign);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

import com.wx.entity.Coacher;

/**
 *
 * @author wewezhu
 */
public interface CoacherDAO {

    /**
     * Add coacher method
     * @param coacher
     * @return 
     */
    Coacher addCoacher(Coacher coacher);

    Coacher findCoacherByName(String name);

    Coacher findCoaherById(String id);

    boolean reomveCoacher(Coacher coacher);

    Coacher updateCoacher(Coacher coacher);
    
}

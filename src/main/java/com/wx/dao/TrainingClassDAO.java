/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.dao;

import com.wx.entity.TrainingClass;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface TrainingClassDAO {

    TrainingClass addTrainingClass(TrainingClass trainingClass);

    List<TrainingClass> findTrainingClassByCoacher(Long coacherId);

    List<TrainingClass> findTrainingClassByCustomer(Long customerId);

    TrainingClass findTrainingClassById(Long classId);

    boolean removeTrainingClass(TrainingClass trainingClass);

    TrainingClass updateTrainingClass(TrainingClass trainingClass);
    
}

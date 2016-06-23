/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import java.io.File;

/**
 *
 * @author wewezhu
 */
public class FileUtils {
    public static void imgFileDirectoryInitialization(String dir){
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.impl;

import com.wx.service.cli.handler.UserNameHandler;
import com.wx.service.cli.message.CheckCommandReturnMessage;

/**
 *
 * @author wewezhu
 */
public class CMDService {
    public static CheckCommandReturnMessage processCheckingCommand(String command) throws Exception{
       System.out.println("CheckCommandReturnMessage.command:"+command);
        String[] commands = command.split(" ");
       
       CheckCommandReturnMessage message = new CheckCommandReturnMessage();
       
       message.setUserInfos(UserNameHandler.getUserName(commands[0]));
       message.setContent(commands[1]);
       
       return message;
       
    }
    
    public static void main(String[] args){
        String cmd = "@zhuwei8231 测试下";
        String[] cmds = cmd.split(" ");
        
            System.out.println(cmds[0]);
        System.out.println(cmds[1]);
    }
}

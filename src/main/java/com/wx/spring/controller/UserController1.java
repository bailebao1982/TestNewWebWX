/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.spring.controller;

import com.wx.dao.CustomerDAO;
import com.wx.entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wewezhu
 */
@Controller  
@RequestMapping("/customer")  
public class UserController1 {
    
    @Resource(name="customerDAO")  
    private CustomerDAO userManager;  
  
    @RequestMapping("/getAllUser")  
    public String getAllUser(HttpServletRequest request){  
          
        request.setAttribute("userList", userManager);  
          
        return "/index";  
    }  
      
    @RequestMapping("/getUser")  
    public String getUser(String id,HttpServletRequest request){  
          
        request.setAttribute("user", userManager.findCustomerById(id));  
      
        return "/editUser";  
    }  
      
    @RequestMapping("/toAddUser")  
    public String toAddUser(){
        System.out.println("run in controller.");
        return "customer/addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(Customer user,HttpServletRequest request){  
          
        userManager.addCustomer(user);  
          
        return "redirect:/customer/getAllUser";  
    }  
      
    @RequestMapping("/delUser")  
    public void delUser(String id,HttpServletResponse response){  
          
        String result = "{\"result\":\"error\"}";  
          Customer removeCustomer = userManager.findCustomerById(id);
        if(userManager.removeCustomer(removeCustomer)){  
            result = "{\"result\":\"success\"}";  
        }  
          
        response.setContentType("application/json");  
          
        try {  
            PrintWriter out = response.getWriter();  
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    @RequestMapping("/updateUser")  
    public String updateUser(Customer user,HttpServletRequest request){  
         /*** 
        if(userManager.updateCustomer(user)){  
            user = userManager.updateCustomer(user.getId());  
            request.setAttribute("user", user);  
            return "redirect:/user/getAllUser";  
        }else{  
            return "/error";  
        }  
        * 
        * **/
         return null;
    }  
}

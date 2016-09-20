/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.spring.controller;

import com.wx.entity.Customer;
import com.wx.service.BMService;
import com.wx.service.CustomerService;
import com.wx.service.SalesService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wewezhu
 */
@Controller
@RequestMapping("/Customer")  
public class CustomerController {
    
    @Resource(name="customerService") 
    private CustomerService customerService;
    
    @Resource(name="salesService") 
    private SalesService saleService;
    
    @Resource(name="bmService") 
    private BMService bmService;
    
    @RequestMapping("/getCustomer")
    public String getAllCustomers(HttpServletRequest request,Customer customer){
        System.out.println("Enter:Run at Controller: CustomerController:getAllCustomers");
        
        
        request.setAttribute("userList", customerService.getAllCustomer()); 
        request.setAttribute("saleList", saleService.getAllSalesRecordsByCustomer("Shi.Yi.Ting"));
        request.setAttribute("bmList",bmService.getAllBMByCustomerId(customer.getId()));
        request.setAttribute("regClass",79);
         System.out.println("Outer:Run at Controller: CustomerController:getAllCustomers");
        return "Customer/userInfo";
    
    }
    
    
    
      @RequestMapping("/addCustomer")  
    public String addUser(Customer customer,HttpServletRequest request){  
          
        customerService.addNewCustomer(customer);  
          
        return "redirect:/Customer/userInfo";  
    }  
}

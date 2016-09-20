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
import com.wx.ui.sale.bean.SaleInfoBean;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wewezhu
 */
@Controller
@RequestMapping("/Sale")  
public class SalesController {
    
     @Resource(name="customerService") 
    private CustomerService customerService;
    
    @Resource(name="salesService") 
    private SalesService saleService;
    
    @Resource(name="bmService") 
    private BMService bmService;
    
     @RequestMapping(value = "/viewSaleRecord",method = RequestMethod.GET)
    public String viewSalesRecord(@RequestParam String SaleRecordId,HttpServletRequest request,Model model){
        System.out.println("Enter:Run at Controller: SalesController:getAllCustomers");
       
        
        System.out.println("recId:"+SaleRecordId);
         
        request.setAttribute("saleRec", saleService.findSalesRecordById(SaleRecordId)); 
        request.setAttribute("totalSalesCls", 100);
        request.setAttribute("totalUsedCls",40);
        model.addAttribute("saleInfo", new SaleInfoBean());
         System.out.println("Outer:Run at Controller: SalesController:getAllCustomers");
        return "Sale/viewSale";
    
    }
    
    
    @RequestMapping(value = "/eidtSaleRecord",method = RequestMethod.GET)
    public String editSalesRecord(@RequestParam String SaleRecordId,@ModelAttribute SaleInfoBean saleInfoBean, HttpServletRequest request){
        System.out.println("Enter:Run at Controller: editSalesRecord");
       
        
        System.out.println("recId:"+SaleRecordId);
         
        request.setAttribute("saleRec", saleService.findSalesRecordById(SaleRecordId)); 
        
       
         System.out.println("Outer:Run at Controller: editSalesRecord");
        return "Sale/editSale";
    
    }
    
    @RequestMapping(value = "/submitSaleRecord",method = RequestMethod.POST)
    public String submitSalesRecord(@ModelAttribute SaleInfoBean saleInfoBean, HttpServletRequest request){
        System.out.println("Enter:Run at Controller: submitSalesRecord");
       
        System.out.println(saleInfoBean.getUnitPrice());
        request.setAttribute("totalSalesCls", 100);
        request.setAttribute("totalUsedCls",40);
         System.out.println("Outer:Run at Controller: submitSalesRecord");
        return "Sale/viewSale";
    
    }
    
}

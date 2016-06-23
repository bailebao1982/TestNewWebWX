/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.wx.response.message.BaseMessage;
import com.wx.response.message.NewsMessage;
import com.wx.response.message.TextMessage;
import com.wx.service.ClassService;
import com.wx.service.impl.CoreService;
import com.wx.util.AccessTokenGen;
import com.wx.util.MessageUtil;
import com.wx.util.QyWxURLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wewezhu
 */
public class CoacherWXServlet extends HttpServlet {

    ServletConfig config;

    ClassService classService;
    
 public void init(ServletConfig config) throws ServletException {
        try {
            super.init(config);
            this.config = config;
           
            //Initialize Spring context
            ApplicationContext context = new ClassPathXmlApplicationContext("/com/wx/config/spring-common.xml");
            if (context != null) {
                System.out.println("context is not null");
                ClassService service = (ClassService) context.getBean("classService");
                if (service != null) {
                    classService = service;

                    System.out.println("ClassService is not null;");
                } else {
                    System.out.println("ClassService is null");
                }
            } else {
                System.out.println("context is null");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerWXServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //processRequest(request, response);
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //企业号的基本信息，配置时填写
        String sToken = "testToken1";
        String sCorpID = "wxe706b25abb1216c0";
        String sEncodingAESKey = "R5zQRNXirEIQsSGL5Hs5ydZdSuu7EkRLWLViul1P7si";

        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);

// 解析出url上的参数值如下：
            //URLDecoder.decode(request.getParameter("echostr"),"utf-8");
            String sVerifyMsgSig = URLDecoder.decode(request.getParameter("msg_signature"), "utf-8");
            String sVerifyTimeStamp = URLDecoder.decode(request.getParameter("timestamp"), "utf-8");
            String sVerifyNonce = URLDecoder.decode(request.getParameter("nonce"), "utf-8");
            String sVerifyEchoStr = URLDecoder.decode(request.getParameter("echostr"), "utf-8");

            PrintWriter out = response.getWriter();
            String sEchoStr; //需要返回的明文
            try {
                sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
                System.out.println("verifyurl echostr: " + sEchoStr);
// 验证URL成功，将sEchoStr返回
                out.print(sEchoStr);
                out.close();
                out = null;
            } catch (Exception e) {
//验证URL失败，错误原因请查看异常
                e.printStackTrace();
            }

        } catch (AesException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String sToken = "testToken1";
        String sCorpID = "wxe706b25abb1216c0";
        String sEncodingAESKey = "R5zQRNXirEIQsSGL5Hs5ydZdSuu7EkRLWLViul1P7si";
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String msg_signature = request.getParameter("msg_signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        InputStream inputStream = request.getInputStream();
        String postData = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(postData);
        String msg = "";
        WXBizMsgCrypt wxcpt = null;
        try {
            wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
            //解密消息
            msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
        } catch (AesException e) {
            e.printStackTrace();
        }
        System.out.println("msg=" + msg);
        BaseMessage respMessage = CoreService.processRequest(msg,classService);
        String resMsg = null;
       /** if (request.getSession().getAttribute("accessToken") == null) {
            try {
                String accessToken = CoreService.getAccessToken(config.getInitParameter("corpid"), config.getInitParameter("corpsecret"));
                request.getSession().setAttribute("accessToken", accessToken);
                QyWxURLUtil.applyAccessToken(accessToken);
            } catch (Exception ex) {
                Logger.getLogger(TestWXServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        **/
        /**
         * UploadMediaReturnMessage uploadMediaReturnMsg; try {
         * uploadMediaReturnMsg = WXUtils.send("image",
         * "/root/WXMedia/anranhui520/1.jpg");
         * if("null".equals(uploadMediaReturnMsg.getErrcode())){
         * System.out.println("Media_id:"+uploadMediaReturnMsg.getMedia_id());
         * }else{ System.out.println("Upload error
         * message:"+uploadMediaReturnMsg.getErrmsg()+" error
         * code:"+uploadMediaReturnMsg.getErrcode());
         *
         * }
         * } catch (Exception ex) {
         * Logger.getLogger(TestWXServlet.class.getName()).log(Level.SEVERE,
         * null, ex); }
        *
         */
        if (respMessage instanceof TextMessage) {
            /*try {
                TextMessage txtMsg = (TextMessage) respMessage;

                String command = txtMsg.getContent();

                CheckCommandReturnMessage ccReturnMsg = CMDService.processCheckingCommand(command);
                Set<UserInfo> userInfoSet = ccReturnMsg.getUserInfos();
                UserInfo userif = null;
                for (UserInfo userInfo : userInfoSet) {
                    userif = userInfo;
                }

                System.out.println("msgContent:" + ccReturnMsg.getContent());
                System.out.println("weixinid:" + userif.getWeixinid());

                try {

                    UploadMediaReturnMessage uploadMediaReturnMsg = null;
                    try {
                        QRCodeGenerator.encode(ccReturnMsg.getContent(), "/root/WXMedia/"+userif.getWeixinid());
                        
                        uploadMediaReturnMsg = WXUtils.send("image", "/root/WXMedia/"+userif.getWeixinid()+"/qrcode.jpg");
                        if ("null".equals(uploadMediaReturnMsg.getErrcode())) {
                            System.out.println("Media_id:" + uploadMediaReturnMsg.getMedia_id());
                        } else {
                            System.out.println("Upload error message:" + uploadMediaReturnMsg.getErrmsg() + " error code:" + uploadMediaReturnMsg.getErrcode());

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CustomerWXServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }*/

                    /**
                     * TextSendMessage textMsg = new TextSendMessage(); String
                     * msgtxt = ccReturnMsg.getContent();
                     * textMsg.setTextContent(msgtxt);
                     * textMsg.setMsgtype("text");
                     * textMsg.setTouser(userif.getWeixinid());
                     * textMsg.setAgentid(Long.parseLong(config.getInitParameter("checkingAgentId"))); *
                     */
                  /*  ImageSendMessage imgMsg = new ImageSendMessage();
                    imgMsg.setImageMedia(uploadMediaReturnMsg.getMedia_id());
                    imgMsg.setMsgtype("image");
                    imgMsg.setTouser(userif.getWeixinid());
                    imgMsg.setAgentid(Long.parseLong(config.getInitParameter("checkingAgentId")));

                    AccessTokenReturnMessage returnMsg = CoreService.sendMessage(imgMsg);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerWXServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(CustomerWXServlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } else if (respMessage instanceof NewsMessage) {
            System.out.println("enter NewsMessage.");
            NewsMessage newsMsg = (NewsMessage) respMessage;
            resMsg = MessageUtil.newsMessageToXml(newsMsg);
            System.out.println("ResMsg:" + resMsg);
        }
        PrintWriter out = response.getWriter();
        out.print(resMsg);
        out.flush();
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

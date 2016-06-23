/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.service.impl;

import com.wx.CustomerWXServlet;
import com.wx.bo.Attr;
import com.wx.bo.DeptUsers;
import com.wx.bo.UserInfo;
import com.wx.bo.UserInfoExtraAttr;
import com.wx.corprcv.message.AccessTokenReturnMessage;
import com.wx.corprcv.message.UploadMediaReturnMessage;
import com.wx.corpsend.message.CorpSendBase;
import com.wx.corpsend.message.ImageSendMessage;
import com.wx.corpsend.message.TextSendMessage;
import com.wx.entity.RegisterClass;
import com.wx.response.message.Article;
import com.wx.response.message.BaseMessage;
import com.wx.response.message.NewsMessage;
import com.wx.response.message.TextMessage;
import com.wx.service.ClassService;
import com.wx.util.HttpUtil;
import com.wx.util.MessageUtil;
import com.wx.util.QRCodeGenerator;
import com.wx.util.QyWxURLUtil;
import com.wx.util.WXUtils;
import java.util.Map;
import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wewezhu
 */
public class CoreService {

    private static Object UserInfoExtraAttr;

    /**
     * 获取成员 请求说明 Https请求方式: GET
     * https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=lisi
     * 参数说明 参数	必须	说明 access_token	是	调用接口凭证 userid	是	员工UserID。对应管理端的帐号 返回结果 {
     * "errcode": 0, "errmsg": "ok", "userid": "zhangsan", "name": "李四",
     * "department": [1, 2], "position": "后台工程师", "mobile": "15913215421",
     * "email": "zhangsan@gzdev.com", "weixinid": "lisifordev", "avatar":
     * "http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0",
     * "status": 1, "extattr":
     * {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
     * }
     *
     *
     * 参数	说明 errcode	返回码 errmsg	对返回码的文本描述内容 userid	员工UserID。对应管理端的帐号 name	成员名称
     * department	成员所属部门id列表 position	职位信息 mobile	手机号码 email	邮箱 weixinid	微信号
     * avatar	头像url。注：如果要获取小图将url最后的"/0"改成"/64"即可 status	关注状态: 1=已关注，2=已冻结，4=未关注
     * extattr	扩展属性 权限说明 管理员须拥有’获取成员’的接口权限，以及成员的查看权限。
     *
     * @param acessToken
     * @param userId
     * @return
     * @throws Exception
     */
    public static UserInfo getUserInfoFromUserID(String userId) throws Exception {
        System.out.println("getUserInfoFromUserID.userId" + userId);
        String queryUserURL = QyWxURLUtil.getQueryUserURL();
        queryUserURL = MessageFormat.format(queryUserURL, 0, userId);
        System.out.println("getUserInfoFromUserID.queryUserURL" + queryUserURL);
        String returnMsg = HttpUtil.httpGet(queryUserURL);

        JSONObject jsonObj1 = JSONObject.fromObject(returnMsg);
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("extattr", UserInfoExtraAttr.class);
        classMap.put("attrs", Attr.class);
        UserInfo info = (UserInfo) JSONObject.toBean(jsonObj1, UserInfo.class, classMap);

        return info;
    }

    public static DeptUsers getDeptUsersByDeptId(String accessToken, boolean recursive, String status) {

        return null;
    }

    public static AccessTokenReturnMessage sendMessage(CorpSendBase message) {
        String SEND_MSG_URL = QyWxURLUtil.getMsgSendURL();
        try {
            //创建连接
            URL url = new URL(SEND_MSG_URL);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.connect();

            //POST请求
            JSONObject obj = JSONObject.fromObject(message);
            System.out.println("JsonObject:" + obj.toString());

            //DataOutputStream out = new DataOutputStream(
            //        connection.getOutputStream());
            //out.writeBytes(obj.toString());
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "utf-8"));
            out.write(obj.toString());
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();

            JSONObject jsonObj1 = JSONObject.fromObject(sb.toString());
            AccessTokenReturnMessage p2;
            p2 = (AccessTokenReturnMessage) JSONObject.toBean(jsonObj1, AccessTokenReturnMessage.class);

            // 断开连接
            connection.disconnect();
            return p2;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String processTextCMD(String messageCMD) {
        if (messageCMD.startsWith("@")) {
            //找到@后面的人
            String[] words = messageCMD.split(" ");
            String userid = words[0].substring(1, words[0].length());

            String content = words[1];

            System.out.println("userid:" + userid);
            System.out.println("content:" + content);
        }
        return "successful";
    }

    public static BaseMessage processRequest(String msg, ClassService classService) {
        String respMessage = null;
        BaseMessage returnMsg = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, Object> requestMap = MessageUtil.parseXml(msg);

            System.out.println("Event==" + requestMap.get("Event"));

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName").toString();

            // 公众帐号
            String toUserName = requestMap.get("ToUserName").toString();

            //String toUserName = "anranhui520";
            // 消息类型
            String msgType = requestMap.get("MsgType").toString();

			// 回复文本消息
			/* TextMessage textMessage = new TextMessage();
             textMessage.setToUserName(fromUserName);
             textMessage.setFromUserName(toUserName);
             textMessage.setCreateTime(new Date().getTime());
             textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
             textMessage.setFuncFlag(0);
             */
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                String content = requestMap.get("Content").toString();
                returnMsg = new TextMessage();
                returnMsg.setToUserName(toUserName);
                returnMsg.setFromUserName(fromUserName);
                returnMsg.setCreateTime(new java.util.Date().getTime());
                returnMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                returnMsg.setFuncFlag(0);
                ((TextMessage) returnMsg).setContent(content);
                /**
                 * NewsMessage newsMessage = new NewsMessage();
                 * newsMessage.setToUserName(fromUserName);
                 * newsMessage.setFromUserName(toUserName);
                 * newsMessage.setCreateTime(new Date().getTime());
                 * newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                 * newsMessage.setFuncFlag(0);
                 *
                 * List<Article> articleList = new ArrayList<Article>(); Article
                 * article = new Article(); article.setTitle("微信公众帐号开发教程Java版");
                 * article.setTitle("微信公众帐号开发教程Java版");
                 * article.setDescription("柳峰，80后，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列教程，也希望借此机会认识更多同行！");
                 * article.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
                 * article.setUrl("http://blog.csdn.net/lyq8479");
                 * articleList.add(article); // 设置图文消息个数
                 * newsMessage.setArticleCount(articleList.size()); //
                 * 设置图文消息包含的图文集合 newsMessage.setArticles(articleList); //
                 * 将图文消息对象转换成xml字符串 respMessage =
                 * MessageUtil.newsMessageToXml(newsMessage); returnMsg =
                 * newsMessage; 8
                 */

            } // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {

            } // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                //respContent = "Sunlight提示：您发送的是地理位置消息！"; 
            } // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                //respContent = "Sunlight提示：您发送的是链接消息！";
            } // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                //respContent = "Sunlight提示：您发送的是音频消息！";
            } // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event").toString();
                // 自定义菜单点击事件
                if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey").toString();
                    System.out.println("EventKey=" + eventKey);
                    UserInfo userif = getUserInfoFromUserID(fromUserName);
                    StringBuffer qrcode_content = new StringBuffer();
                    if (eventKey.equals("11")) {
                        //qrcode_content.append("@英派斯");
                        qrcode_content.append("@OM@会员提供场地");
                    } else if (eventKey.equals("12")) {
                        qrcode_content.append("@OO@会员提供场地");
                    } else if (eventKey.equals("13")) {
                        //qrcode_content.append("@宝力豪");
                        qrcode_content.append("@OM@和静工作室");
                    } else if (eventKey.equals("14")) {
                        qrcode_content.append("@OO@和静工作室");
                    }
                    qrcode_content.append("@" + userif.getName());

                    qrcode_content.append("@" + fromUserName);
                    //Date currentTime = new Date(System.currentTimeMillis());
                    qrcode_content.append("@" + System.currentTimeMillis());

                    //Generate UUID signature
                    UUID uuid = UUID.randomUUID();
                    String uuidStr = uuid.toString();
                    qrcode_content.append("@" + uuidStr.replaceAll("-", ""));

                    UploadMediaReturnMessage uploadMediaReturnMsg = null;
                    try {
                        String imgDir = "/root/WXMedia/" + fromUserName;
                        com.wx.util.FileUtils.imgFileDirectoryInitialization(imgDir);
                        QRCodeGenerator.encode(qrcode_content.toString(), "/root/WXMedia/" + fromUserName);

                        uploadMediaReturnMsg = WXUtils.send("image", "/root/WXMedia/" + fromUserName + "/qrcode.jpg");
                        if ("null".equals(uploadMediaReturnMsg.getErrcode())) {
                            System.out.println("Media_id:" + uploadMediaReturnMsg.getMedia_id());
                        } else {
                            System.out.println("Upload error message:" + uploadMediaReturnMsg.getErrmsg() + " error code:" + uploadMediaReturnMsg.getErrcode());

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CustomerWXServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ImageSendMessage imgMsg = new ImageSendMessage();
                    imgMsg.setImageMedia(uploadMediaReturnMsg.getMedia_id());
                    imgMsg.setMsgtype("image");
                    imgMsg.setTouser(fromUserName);
                    //imgMsg.setTouser("anranhui520");
                    imgMsg.setAgentid((long) 2);
                    sendMessage(imgMsg);

                    TextSendMessage txtMsg = new TextSendMessage();
                    txtMsg.setMsgtype("text");
                    txtMsg.setTextContent("如果要删除签课记录，同一签课表扫描两次.");
                    txtMsg.setAgentid((long) 2);
                    txtMsg.setTouser(fromUserName);
                    sendMessage(txtMsg);
                    // respContent = "Sunlight提示：您点击的菜单KEY是"+eventKey;
                } else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SCAN_CODE)) {
                    String eventKey = requestMap.get("EventKey").toString();
                    System.out.println("EventKey=" + eventKey);

                    if (eventKey.equals("31")) {
                        Map<String, String> scanCodeInfo = (Map<String, String>) requestMap.get("ScanCodeInfo");
                        String scanResult = scanCodeInfo.get("ScanResult");
                        System.out.println("ScanResult:" + scanResult);
                    }

                } else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_SCAN_CODE_WAIT_MSG)) {
                    String eventKey = requestMap.get("EventKey").toString();
                    System.out.println("EventKey=" + eventKey);

                    if (eventKey.equals("21")) {
                        Map<String, String> scanCodeInfo = (Map<String, String>) requestMap.get("ScanCodeInfo");
                        String scanResult = scanCodeInfo.get("ScanResult");
                        System.out.println("ScanResult:" + scanResult);
                        //process scan result
                        String[] results = scanResult.split("@");
                        //add class Type
                        System.out.println("ClassType:" + results[1]);

                        System.out.println("place:" + results[2]);

                        System.out.println("coacher:" + results[3]);
                        System.out.println("coacher weixin:" + results[4]);
                        System.out.println("time:" + results[5]);
                        System.out.println("signature:" + results[6]);

                        RegisterClass classInfo = classService.findRegisterClassBySignature(results[6]);

                        StringBuffer replyResult = new StringBuffer();

                        StringBuffer coacherReplyResult = new StringBuffer();
                        Date dateTime = new Date(Long.parseLong(results[5].toString()));
                        Time time = new Time(Long.parseLong(results[5].toString()));
                        UserInfo userif = getUserInfoFromUserID(fromUserName);
                        String classType = results[1];
                        //TODO:如果ClassType是OM，则消息要发送给OM的对应的每个客户
                        String registerFromUser = fromUserName;
                        String[] messageSendUsers;
                        List<String> messageSendUserList = new ArrayList<String>();

                        if ("OO".equals(classType)) {
                            registerFromUser = fromUserName;
                            messageSendUsers = new String[1];
                            messageSendUsers[0] = registerFromUser;
                            messageSendUserList = Arrays.asList(messageSendUsers);
                        } else if ("OM".equals(classType)) {
                            //TODO: 增加方法从CustomerGroup里根据FromUserName拿GroupName
                            registerFromUser = classService.findCustomerGroupNameByCustomerName(fromUserName);
                            messageSendUsers = classService.findCustomersByCustomerGroupName(registerFromUser);
                            for(String messageSendUser:messageSendUsers){
                                System.out.println("messageSendUser:"+messageSendUser);
                            }
                            
                            messageSendUserList = Arrays.asList(messageSendUsers);

                        }

                        if (classInfo == null) {

                            boolean registerResult = classService.registerClass(classType, results[3], registerFromUser, dateTime, time, results[2], results[6]);

                            if (registerResult) {
                                int allRegisterClass = classService.getCustomerAllRegisterClass(registerFromUser, classType);
                                int salesRecord = classService.getSalesRecordNumByCustomer(registerFromUser, classType);

                                int remainRecord = salesRecord - allRegisterClass;

                                replyResult.append("恭喜又完成了一次训练！\n");
                                int weekCount = classService.counterRegisterClassByNameRecentWeek(fromUserName, dateTime,classType);
                                replyResult.append("截至这次，本周共完成训练 " + weekCount + "次。\n");
                                int monthCount = classService.counterRegisterClassByNameRecentMonth(fromUserName, dateTime,classType);
                                replyResult.append("本月共完成训练 " + monthCount + "次。\n");
                                replyResult.append("剩余使用次数 " + remainRecord + "次。\n");

                                //int yearCount = classService.counterRegisterClassByNameRecentYear(fromUserName, dateTime);
                                //replyResult.append("今年总共完成训练 " + yearCount + "次。");
                                coacherReplyResult.append(userif.getName() + "截至这次，本周共完成训练 " + weekCount + "次。\n");
                                coacherReplyResult.append("本月共完成训练 " + monthCount + "次。\n");

                                coacherReplyResult.append("剩余使用次数 " + remainRecord + "次。\n");
                            }
                        } else {

                            System.out.println("删除签课表。");
                            classService.deleteRegisterClassBySignature(results[6]);
                            replyResult.append("成功删除签课记录：" + "场地:" + results[2] + " 教练：" + results[3] + " 时间:" + dateTime);
                            coacherReplyResult.append("成功删除签课记录：" + "场地:" + results[2] + " 教练：" + results[3] + " 时间:" + dateTime);
                        }

                        //Change Log: 给每个用户发送消息
                        //针对 一对一私教，只发送一个消息
                        //针对一对多私教，给用户group的每个人发送消息
                        System.out.println("scanResult:" + scanCodeInfo.get("ScanResult"));
                        System.out.println("messageSendUserList:" + messageSendUserList.toString());
                        for (String sendUser : messageSendUserList) {
                            TextSendMessage txtMsg = new TextSendMessage();
                            txtMsg.setMsgtype("text");
                            txtMsg.setTextContent(replyResult.toString());
                            txtMsg.setAgentid((long) 1);
                            txtMsg.setTouser(sendUser);
                            sendMessage(txtMsg);
                        }
                        
                        TextSendMessage txtMsg1 = new TextSendMessage();
                        txtMsg1.setMsgtype("text");
                        txtMsg1.setTextContent(coacherReplyResult.toString());
                        txtMsg1.setAgentid((long) 2);
                        txtMsg1.setTouser(results[4]);

                        sendMessage(txtMsg1);

                    }
                }
            }

            //textMessage.setContent(respContent);
            //respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            respMessage = "有异常了。。。";
        }
        return returnMsg;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();

        System.out.println(uuidStr.replaceAll("-", ""));
    }
}

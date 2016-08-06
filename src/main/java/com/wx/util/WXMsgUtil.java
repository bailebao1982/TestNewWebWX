/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import com.wx.corprcv.message.AccessTokenReturnMessage;
import com.wx.corpsend.message.CorpSendBase;
import com.wx.corpsend.message.IMessage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import net.sf.json.JSONObject;

/**
 *
 * @author wewezhu
 */
public class WXMsgUtil {
    public static AccessTokenReturnMessage sendMessage(IMessage message,String urlStr) {
      
        try {
            //创建连接
            URL url = new URL(urlStr);
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
}

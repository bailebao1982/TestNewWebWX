/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wx.util;

import net.sf.json.JSONObject;

/**
 *
 * @author wewezhu
 */
public class QiYeUtil {
  
	/**
	 * OAuth2验证接口根据code获取成员信息
	 * 
	 * @param token
	 * @param code
	 * @param AgentID
	 * @return
	 */
	public static Result<String> oAuth2GetUserByCode(String token, String code,
			int AgentID) {
		Result<String> result = new Result<String>();
		JSONObject jo = WechatOAuth2.getUserByCode(token, code, AgentID);
		if (jo != null) {
			try {
				String userId = jo.getString("UserId");
				if (userId != null && userId.length() > 0) {
					result.setErrmsg("");
					result.setErrcode("0");
					result.setObj(userId);
				} else {
					result.setErrmsg(jo.getString("errmsg"));
					result.setErrcode(jo.getString("errcode"));
				}

			} catch (Exception e) {
				result.setErrmsg("accessToken 超时......");
				result.setErrcode("42001");
			}
		}
		return result;
	}
}

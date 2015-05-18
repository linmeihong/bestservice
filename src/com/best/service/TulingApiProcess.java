package com.best.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TulingApiProcess {
	/**
	 * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
	 * 
	 * @param content
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws JSONException 
	 */
	public String getTulingResult(String content) throws ClientProtocolException, IOException, JSONException {
		/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 */
		String apiUrl = "http://www.tuling123.com/openapi/api?key=bbd8a4a301d6540ec0ab333d0a9adb6d&info=";
		String param = "";

		param = apiUrl + URLEncoder.encode(content, "utf-8");
		/** 发送httpget请求 */
		HttpGet request = new HttpGet(param);
		String result = "";

		HttpResponse response = HttpClients.createDefault().execute(request);
		if (response.getStatusLine().getStatusCode() == 200) {
			result = EntityUtils.toString(response.getEntity());
		}
		// System.out.println("tuling result:"+result);

		/** 请求失败处理 */
		if (null == result) {
			return "对不起，你说的话真是太高深了……";
		}

		JSONObject json = new JSONObject(result);
		// 以code=100000为例，参考图灵机器人api文档
		result = json.getString("text");
//		if (100000 == json.getInt("code")) {
//			result = json.getString("text");
//		}
//		
		
		return result;
	}

}

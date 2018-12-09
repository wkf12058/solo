package com.solo.util.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.solo.util.basics.MyHttpRequest;


public class WxUtil {
    
    private final static String appId="wxbc21ff19883eaf43";
    private final static String appSecret="381a3d03accd62841f3b7bf720181eba";

    
    public static Map<String, Object> openId(String code){ // 小程序端获取的CODE
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        try {
            boolean check = (StringUtils.isEmpty(code)) ? true : false;
            if (check) {
                throw new Exception("参数异常");
            }
            StringBuilder urlPath = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session"); // 微信提供的API，这里最好也放在配置文件
            urlPath.append(String.format("?appid=%s", appId));
            urlPath.append(String.format("&secret=%s", appSecret));
            urlPath.append(String.format("&js_code=%s", code));
            urlPath.append(String.format("&grant_type=%s", "authorization_code")); // 固定值
            String data = MyHttpRequest.sendPost(urlPath.toString(),null); // java的网络请求，这里是我自己封装的一个工具包，返回字符串
            System.out.println("请求结果：" + data);
            JSONObject jsStr = JSONObject.parseObject(data);
            result.put("openId", jsStr.get("openid"));
            result.put("sessionKey", jsStr.get("session_key"));
        } catch (Exception e) {
            result.put("code", 1);
            result.put("remark", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

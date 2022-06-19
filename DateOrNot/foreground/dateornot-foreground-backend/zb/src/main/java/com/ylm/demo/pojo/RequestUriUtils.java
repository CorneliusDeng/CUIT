package com.ylm.demo.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * uri请求参数获取工具类，获取uri携带的参数
 */
public class RequestUriUtils {

    /**
     * 读取请求路径中的参数并存入map中
     * @param uri 传入的携带参数的路径
     * @return
     */
    public static Map<String, String> getParams(String uri) {
        Map<String, String> params = new HashMap<>(10);

        int idx = uri.indexOf("?");
        if (idx != -1) {
            String[] paramsArr = uri.substring(idx + 1).split("&");

            for (String param : paramsArr) {
                idx = param.indexOf("=");
                params.put(param.substring(0, idx), param.substring(idx + 1));
            }
        }

        return params;
    }

    /**
     * 获取剔除参数的uri
     * @param uri
     * @return
     */
    public static String getBasePath(String uri) {
        if (uri == null || uri.isEmpty()){
            return null;
        }

        int idx = uri.indexOf("?");
        if (idx == -1){
            return uri;
        }

        return uri.substring(0, idx);
    }

    public static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
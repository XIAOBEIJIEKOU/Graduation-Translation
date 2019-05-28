package com.graduation.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.graduation.demo.api.TransApi;
import org.springframework.stereotype.Component;

@Component
public class TranslateService {

    private static final String APP_ID = "20190430000292981";
    private static final String SECURITY_KEY = "Vn8bbuQFCylaO47v2EDi";

    public static String translate(String query , String to) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        System.out.println(api.getTransResult(query, "auto", to));
        String result =  api.getTransResult(query, "auto", to);
        JSONObject jsonResult = JSONObject.parseObject(result);
        JSONArray jsonArray = jsonResult.getJSONArray("trans_result");
        String  content = jsonArray.getJSONObject(0).getString("dst");
        return content;
    }
}

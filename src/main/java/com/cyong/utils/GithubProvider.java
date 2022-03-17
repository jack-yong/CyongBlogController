package com.cyong.utils;


import com.alibaba.fastjson.JSON;
import com.cyong.model.AccessTokenDTO;
import com.cyong.model.GithubUser;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2022-03-14 10:10
 * @Description: http相关的辅助操作
 */

@Component
public class GithubProvider  {
    //okhttp POST方法带着使用fastJson将五个参数转换成的Json数据去请求github的access_token地址。
    //返回access_token字符串，截取拿到access_token。
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        //将accessTokenDTO转换成Json类型
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    //再使用okhttp GET去请求github的user地址+access_token,得到user信息，
    //使用fastJson的Json.parseObject(String,GithubUser.class)，将String解析成类对象。
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //fastJson的JSON.parseObject方法可以自动将String解析成类(GithubUser)对象。
            //GithubUser里的值都可以获得
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }

}

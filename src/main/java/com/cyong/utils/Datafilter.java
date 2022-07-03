package com.cyong.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyong.model.Category;
import com.cyong.model.Tag;
import com.cyong.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cyong.utils.TimeUtil;

import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2022-05-30 21:10
 * @Description: 数据过滤类
 */
@Component
public class Datafilter {

    @Autowired
    private TimeUtil timeUtil;

    public JSONArray Categoryfilter(List<Category> categorys){
        JSONArray absjsonlist = new JSONArray();
        for(Category item:categorys){
            JSONObject itemobject =new JSONObject();
            itemobject.put("id",item.getCategoryId());
            itemobject.put("catename",item.getCategoryName());
            itemobject.put("catestatus",item.getCategoryIsDeleted());
            itemobject.put("createtime",timeUtil.getParseDateForSix(item.getCategoryCreateTime()));
            itemobject.put("rank",item.getCategoryRank());
            absjsonlist.add(itemobject);
        }
        return absjsonlist;
    }

    public JSONArray Userfilter(List<User> users){
        JSONArray userList = new JSONArray();
        for(User item:users){
            JSONObject itemobject = new JSONObject();
            itemobject.put("id",item.getUserId());
            itemobject.put("username",item.getUserNickname());
            itemobject.put("password",item.getUserPassword());
            itemobject.put("email",item.getUserEmail());
            itemobject.put("phone",item.getUserPhone());
            itemobject.put("recentlandtime",timeUtil.getParseDateForSix(item.getUserRecentlylanded()));
            itemobject.put("role",item.getUserRole());
            itemobject.put("imageurl",item.getUserAvatarimgurl());
            userList.add(itemobject);
        }
        return userList;
    }

    public JSONArray Tagfilter(List<Tag> Tags){
        JSONArray tagList = new JSONArray();
        for(Tag item:Tags){
            JSONObject itemobject = new JSONObject();
            itemobject.put("id",item.getTagId());
            itemobject.put("tagname",item.getTagName());
            itemobject.put("createTime",timeUtil.getParseDateForSix(item.getTagCreateTime()));
            itemobject.put("isdeleted",item.getTagIsDeleted());
            itemobject.put("tagColor",item.getTagColor());
//            System.out.println("aaaaaaaaaaaaa"+item.getTagColor());
            tagList.add(itemobject);
        }
        return tagList;
    }
}

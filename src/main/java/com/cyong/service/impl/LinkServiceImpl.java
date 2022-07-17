package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.LinkMapper;
import com.cyong.service.LinkService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:17
 * @Description: 友链服务层业务逻辑实现
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public DataMap searchByLinkId(int LinkId) {
        return null;
    }

    @Override
    public JSONObject getLinkCount() {

        try{
            JSONObject LinkObj = new JSONObject();
            int LinkNum = linkMapper.selectLinkNum();
            LinkObj.put("name","link");
            LinkObj.put("Num",LinkNum);
            return LinkObj;
        }
        catch (Exception e){
            System.out.println(e+"getLinkCount");
            return null;
        }
    }


}

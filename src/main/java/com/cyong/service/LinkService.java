package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.model.Link;
import com.cyong.utils.DataMap;

import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:13
 * @Description: 友链服务层业务逻辑
 */
public interface LinkService {
    DataMap searchByLinkId(int LinkId);

    JSONObject getLinkCount();

    DataMap linkVagueSearch(String linkKeyStr,int pageSize, int pageNum,String sorter,String filters);

    DataMap addLink(String linkImage,String linkTitle,String linkDesc,String linkUrl,int linkType);
}

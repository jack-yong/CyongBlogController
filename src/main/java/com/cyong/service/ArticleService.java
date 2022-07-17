package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

import java.util.ArrayList;
import java.util.Date;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-02 15:24
 * @Description: 文章服务层接口
 */
public interface ArticleService {

    DataMap addArticle(String title, String content, int category, String tagList,String coverImage,int status);

    DataMap articleSearch(String title, int category, String tagList, int pageSize, int pageNum, String timeInterval,String sorter,String filters);

    JSONObject getArticleNum();

    DataMap articleCanlder(String year);



}

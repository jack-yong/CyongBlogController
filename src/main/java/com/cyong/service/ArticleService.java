package com.cyong.service;

import com.cyong.utils.DataMap;

import java.util.ArrayList;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-02 15:24
 * @Description: 文章服务层接口
 */
public interface ArticleService {

    DataMap addArticle(String title, String content, int category, String tagList,String coverImage,int status);

    DataMap articleSearch(String title,String category,String tag,int pageSize,int pageNum);
}

package com.cyong.service;

import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-01 16:03
 * @Description: 标签的服务层业务逻辑
 */
public interface TagService {

    DataMap tagVagueSearch(String tagName,int pageSize,int pageNum);

    DataMap addTag(String tagName,String tagColor);

    DataMap searchByTagId(int tagId);

    DataMap searchAllTags();


}

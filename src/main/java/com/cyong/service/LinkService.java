package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

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
}

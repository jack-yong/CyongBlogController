package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-16 14:50
 * @Description: 评论业务的服务层相关业务逻辑
 */
public interface CommentService {
    DataMap searchByCommentId(int comId);

    JSONObject getCommentCount();

}

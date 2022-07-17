package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-16 14:54
 * @Description: 留言相关的服务层业务逻辑
 */
public interface LeaveMessageService {
    DataMap searchByLMId(int LMId);

    JSONObject getLMCount();
}

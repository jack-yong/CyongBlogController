package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:55
 * @Description: 开发日志服务层业务逻辑
 */
public interface DevLogService {
    DataMap searchByDLId(int DLId);

    JSONObject getDLCount();
}

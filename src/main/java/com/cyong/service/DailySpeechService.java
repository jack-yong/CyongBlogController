package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:11
 * @Description: 日常说说服务层业务逻辑
 */
public interface DailySpeechService {
    DataMap searchByDSId(int DSId);

    JSONObject getDSCount();
}

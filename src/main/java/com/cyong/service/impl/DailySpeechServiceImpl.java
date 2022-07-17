package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.DailySpeechMapper;
import com.cyong.service.DailySpeechService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:15
 * @Description: 日常说说服务层业务逻辑实现
 */
@Service
public class DailySpeechServiceImpl implements DailySpeechService {
    @Autowired
    private DailySpeechMapper dailySpeechMapper;

    @Override
    public DataMap searchByDSId(int DSId) {
        return null;
    }

    @Override
    public JSONObject getDSCount() {
        try {
            JSONObject DSObj = new JSONObject();
            int DSNum = dailySpeechMapper.selectDailySpeechNum();
            DSObj.put("name","DS");
            DSObj.put("Num",DSNum);
            return DSObj;
        }
        catch (Exception e){
            System.out.println(e+"getDSCount");
            return null;
        }

    }


}

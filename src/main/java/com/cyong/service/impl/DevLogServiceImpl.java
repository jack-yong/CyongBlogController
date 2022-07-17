package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.DevLogMapper;
import com.cyong.service.DevLogService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:56
 * @Description: 开发日志服务层业务逻辑实现
 */
@Service
public class DevLogServiceImpl  implements DevLogService {

    @Autowired
    private DevLogMapper devLogMapper;

    @Override
    public DataMap searchByDLId(int DLId) {
        return null;
    }

    @Override
    public JSONObject getDLCount() {
        try{
            JSONObject DLObj = new JSONObject();
            int DLNum = devLogMapper.selectDevLogNum();
            DLObj.put("name","DL");
            DLObj.put("Num",DLNum);
            return DLObj;
        }
        catch (Exception e){
            System.out.println(e+"getDLCount");
            return null;
        }

    }


}

package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.LeaveMessageRecordMapper;
import com.cyong.service.LeaveMessageService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:16
 * @Description: 留言服务层业务逻辑实现
 */
@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {

    @Autowired
    private LeaveMessageRecordMapper leaveMessageRecordMapper;

    @Override
    public DataMap searchByLMId(int LMId) {
        return null;
    }

    @Override
    public JSONObject getLMCount() {
        try{
            JSONObject LMRObj = new JSONObject();
            int LMRNum = leaveMessageRecordMapper.selectMessageNum();
            LMRObj.put("name","LMR");
            LMRObj.put("Num",LMRNum);
            return LMRObj;
        }
        catch (Exception e){
            System.out.println(e+"getLMCount");
            return null;
        }

    }



}

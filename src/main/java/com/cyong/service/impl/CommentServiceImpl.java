package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.CommentMapper;
import com.cyong.service.CommentService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 14:52
 * @Description: 评论的服务层业务实现逻辑
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public DataMap searchByCommentId(int comId) {
        return null;
    }

    @Override
    public JSONObject getCommentCount() {
        try{
            JSONObject CommentObj = new JSONObject();
            int commentNum = commentMapper.selectCommentNum();
            CommentObj.put("name","comment");
            CommentObj.put("Num",commentNum);
            return CommentObj;
        }
        catch (Exception e){
            System.out.println(e+"getCommentCount");
            return null;
        }
    }


}

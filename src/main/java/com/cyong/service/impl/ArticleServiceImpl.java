package com.cyong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.BlogMapper;
import com.cyong.dao.BlogTagRelationMapper;
import com.cyong.model.Blog;
import com.cyong.model.BlogTagRelation;
import com.cyong.service.ArticleService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-02 15:25
 * @Description: 文章服务层业务逻辑实现
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Override
    public DataMap addArticle(String title, String content, int category, String tagList, String coverImage, int status) {
        String atitle = title.trim().replace(" ","");
        String acontent = content.trim().replace(" ","");
        JSONArray prasetagList = JSON.parseArray(tagList);
        if(atitle.equals("")){
            DataMap addfail = DataMap.fail(CodeType.ARTICLE_TITLE_BLANK);
            return addfail;
        }
        else if(acontent.equals("")){
            DataMap addfail = DataMap.fail(CodeType.ARTICLE_CONTENT_BLANK);
            return addfail;
        }
        else{

            Date date = new Date();
            Blog blog = new Blog();
            blog.setBlogTitle(title);
            blog.setBlogContent(content);
            blog.setBlogCreateTime(date);
            blog.setBlogCoverImage(coverImage);
            blog.setBlogEnableComment((byte)0);
            blog.setBlogIsDeleted((byte)0);
            blog.setBlogLikes(0l);
            blog.setBlogViews(0l);
            blog.setBlogStatus((byte)status);
            blog.setBlogCategoryId(category);
            try{
                List<String> taglist = JSONArray.parseArray(prasetagList.toJSONString(), String.class);
                blogMapper.insert(blog);
                for (String  tag: taglist) {
                    JSONObject jsonObject = JSON.parseObject(tag);
                    int key =  (int)jsonObject.get("key");
                    BlogTagRelation blogTagRelation = new BlogTagRelation();
                    blogTagRelation.setBtrelationTagId(key);
                    blogTagRelation.setBtrelationBlogId(blog.getBlogId());
                    blogTagRelation.setBtrelationCreateTime(date);
                    blogTagRelationMapper.insert(blogTagRelation);
                }
                DataMap addsuccess = DataMap.success();
                return addsuccess;
            }catch(Exception e){
                System.out.println("expection"+e);
                DataMap addfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
                return addfail;
            }

        }


    }

    @Override
    public DataMap articleSearch(String title, String category, String tag, int pageSize, int pageNum) {
        return null;
    }
}

package com.cyong.service;

import com.cyong.dao.CategoryMapper;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2022-05-12 17:28
 * @Description: 博客类别服务层接口
 */
public interface CategoryService {

    DataMap searchByCateid(int cateid);

    DataMap searchByCateName(String cateName,int pageSize,int pageNum);

    DataMap addCategory(String catename,String imgurl);

    DataMap searchAllCategory();

    DataMap cateVagueSearch(String cateName,int pageSize,int pageNum);



}

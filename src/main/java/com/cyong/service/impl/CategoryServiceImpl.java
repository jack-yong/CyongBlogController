package com.cyong.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.CategoryMapper;
import com.cyong.model.Category;
import com.cyong.service.CategoryService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-05-12 22:00
 * @Description: 博客类别服务层实现
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private  Datafilter datafilter;

    @Override
    public DataMap searchByCateid(int cateid) {
        Category category = categoryMapper.selectByPrimaryKey(cateid);

        if(category!=null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            JSONArray categoryArr = new JSONArray();
            JSONObject categoryObj = new JSONObject();
            categoryObj.put("cateid",category.getCategoryId());
            categoryObj.put("catename",category.getCategoryName());
            categoryObj.put("cateimgurl",category.getCategoryIcon());
            categoryObj.put("catestatus",category.getCategoryIsDeleted());
            categoryObj.put("createtime",sdf.format(category.getCategoryCreateTime()));
            categoryArr.add(categoryObj);
            DataMap categorylist = DataMap.success().setData(categoryArr);
            return categorylist;
        }else{
            DataMap data = DataMap.fail(CodeType.CATEGORY_NOT_EXIST);
            return data;
        }

    }

    @Override
    public DataMap searchByCateName(String cateName, int pageSize, int pageNum) {
        Category category = categoryMapper.searchByCateName(cateName);
        if(category!=null)
        {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            JSONArray categoryArr = new JSONArray();
            JSONObject categoryObj = new JSONObject();
            categoryObj.put("cateid",category.getCategoryId());
            categoryObj.put("catename",category.getCategoryName());
            categoryObj.put("cateimgurl",category.getCategoryIcon());
            categoryObj.put("catestatus",category.getCategoryIsDeleted());
            categoryObj.put("createtime",sdf.format(category.getCategoryCreateTime()));
            categoryArr.add(categoryObj);
            DataMap dmcategory = DataMap.success().setData(categoryArr);
            return dmcategory;
        }else{
            DataMap data = DataMap.fail(CodeType.CATEGORY_NOT_EXIST);
            return data;
        }
    }


    @Override
    public DataMap addCategory(String catename, String imgurl) {
        String ncatename = catename.trim().replace(" ","");
        if(ncatename.equals("")){
            DataMap addfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return addfail;
        }
        else{
            Date date = new Date();
            Category category = new Category();
            category.setCategoryName(ncatename);
            category.setCategoryIcon(imgurl);
            category.setCategoryRank(0);
            category.setCategoryIsDeleted((byte)0);
            category.setCategoryCreateTime(date);
            try{
                categoryMapper.insert(category);
                DataMap addsuccess = DataMap.success();
                return addsuccess;
            }catch(Exception e){
                DataMap addfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
                return addfail;
            }
        }
    }

    @Override
    public DataMap searchAllCategory(int pageSize, int pageNum) {
        JSONObject categoryobj = new JSONObject();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Category> allResult = categoryMapper.searchAllCategory();
            PageInfo<Category> categorys = new PageInfo<>(allResult);
            categoryobj.put("totalNum", categorys.getTotal()); //总记录数目
            categoryobj.put("pages", categorys.getPages()); //总页数
            categoryobj.put("pagesNum", categorys.getPageNum()); //当前页
            categoryobj.put("pagesSize", categorys.getSize()); //每页的数量
            categoryobj.put("data", datafilter.Categoryfilter(allResult));
//            System.out.println(allResult);
            DataMap objectDataMap = DataMap.success().setData(categoryobj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            DataMap searchfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchfail;
        }
        finally {
            PageHelper.clearPage();
        }

    }

    @Override
    public DataMap cateVagueSearch(String cateName, int pageSize, int pageNum) {
        JSONObject categoryobj = new JSONObject();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Category> allResult = categoryMapper.cateVagueSearch(cateName);
            PageInfo<Category> categorys = new PageInfo<>(allResult);
            categoryobj.put("totalNum", categorys.getTotal()); //总记录数目
            categoryobj.put("pages", categorys.getPages()); //总页数
            categoryobj.put("pageNum", categorys.getPageNum()); //当前页
            categoryobj.put("pagesSize", categorys.getSize()); //每页的数量
            categoryobj.put("data", datafilter.Categoryfilter(allResult));
//            System.out.println(allResult);
            DataMap objectDataMap = DataMap.success().setData(categoryobj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            DataMap searchfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchfail;
        }
        finally {
            PageHelper.clearPage();
        }
    }

}

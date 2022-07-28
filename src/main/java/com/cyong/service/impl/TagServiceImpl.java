package com.cyong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.TagMapper;
import com.cyong.model.Category;
import com.cyong.model.Tag;
import com.cyong.service.TagService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-01 16:13
 * @Description: 标签服务层业务逻辑实现
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private Datafilter datafilter;

    @Override
    public DataMap tagVagueSearch(String tagName, int pageSize, int pageNum,String sorter,String filters) {
        JSONObject tagObject = new JSONObject();
        List<String> tagList= new ArrayList<String>();
        String sortField = "";
        String sortOrder = "";
        if(!filters.equals("{}")){
            JSONObject filtersobj = JSONObject.parseObject(filters);
            String isdeleted = (String)filtersobj.get("isdeleted");
            String[] tagStatus = isdeleted.split(",");
//            System.out.println(sorter+"sortersortersorter");
            for (String status : tagStatus) {
                tagList.add(status);
            }
        }
        if(!sorter.equals("")){
            String[] sorterlist = sorter.split("&&");
            sortField = sorterlist[0];
            sortOrder = sorterlist[1];
        }
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Tag> allResult = tagMapper.vagueSearchByTagName(tagName,sortField,sortOrder,tagList);
            PageInfo<Tag> tags = new PageInfo<>(allResult);
            tagObject.put("totalNum", tags.getTotal()); //总记录数目
            tagObject.put("pages", tags.getPages()); //总页数
            tagObject.put("pageNum", tags.getPageNum()); //当前页
            tagObject.put("pagesSize", tags.getSize()); //每页的数量
//            System.out.println(allResult+"allResultallResultallResult");
            tagObject.put("data", datafilter.Tagfilter(allResult));
            DataMap objectDataMap = DataMap.success().setData(tagObject);
            return objectDataMap;
        }catch (Exception e)
        {
//            System.out.println(e+"-----tagVagueSearcherror-----");
            DataMap searchFail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchFail;
        }
        finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public DataMap addTag(String tagName,String tagColor) {
        String ntagName = tagName.trim().replace(" ","");
        if(ntagName.equals("")){
            DataMap addfail = DataMap.fail(CodeType.FIND_TAGS_EXIST);
            return addfail;
        }
        else{
            Date createTime = new Date();
            Tag tag =  new Tag(ntagName,0,createTime,tagColor);
            try{
                tagMapper.insert(tag);
                DataMap success = DataMap.success();
                return success;
            }catch (Exception e){
                DataMap addfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
                return addfail;
            }

        }
    }

    @Override
    public DataMap searchByTagId(int tagId) {
        return null;
    }

    @Override
    public DataMap searchAllTags() {
        List<String> blackList= new ArrayList<String>();
        try{
            List<Tag> allResult = tagMapper.vagueSearchByTagName("","","",blackList);
            DataMap objectDataMap = DataMap.success().setData(datafilter.Tagfilter(allResult));
            return objectDataMap;
        }
        catch (Exception e){
            DataMap searchFail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchFail;
        }
    }

    @Override
    public JSONObject getTagNums() {
        try{
            JSONObject tagObj = new JSONObject();
            int tagNum = tagMapper.selectTagNum();
            tagObj.put("name","tag");
            tagObj.put("title","标签");
            tagObj.put("Num",tagNum);
            return tagObj;
        }
        catch (Exception e){
            System.out.println(e+"getTagNums");
            return null;
        }
    }

    @Override
    public DataMap tagFollowsArticle() {
       try{
           List<Map<String, Object>> tagFollowMaps = tagMapper.tagFollowsArticle();
           DataMap tagFollowDataMap = DataMap.success().setData(tagFollowMaps);
           return tagFollowDataMap;
       }
       catch (Exception e)
       {
           DataMap tagfollowerFail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
           return tagfollowerFail;
       }
    }
}

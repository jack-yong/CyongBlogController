package com.cyong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.BlogMapper;
import com.cyong.dao.BlogTagRelationMapper;
import com.cyong.model.Blog;
import com.cyong.model.BlogTagRelation;
import com.cyong.model.Tag;
import com.cyong.service.ArticleService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.cyong.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private TimeUtil timeUtil;

    @Autowired
    private Datafilter datafilter;

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
    public DataMap articleSearch(String title, int category, String tagList, int pageSize, int pageNum,  String timeInterval, String sorter, String filters) {

        JSONObject articleObj = new JSONObject();
        String statusValue = "";
        String commentStatusValue= "";
//        List<String> STList =  new ArrayList<String>();
        String sortField = "";
        String sortOrder = "";
        String startDate = null;
        String endDate = null;
        if(!filters.isEmpty()){
            JSONObject filtersObj = JSONObject.parseObject(filters);
            if(filtersObj.containsKey("status")){
                String articleStatus = (String)filtersObj.get("status");
                String[] AStatusList = articleStatus.split(",");
                if(AStatusList.length ==1){
                    statusValue =  AStatusList[0];
                }
            }
            if(filtersObj.containsKey("enablecomment")){
                String commentStatus = (String)filtersObj.get("enablecomment");
                String[] CStatusList = commentStatus.split(",");
                if(CStatusList.length ==1){
                    commentStatusValue =  CStatusList[0];
                }
            }
        }
//        if(!tagList.equals("")){
//            String[] selectTList = tagList.split(",");
//            for (String item : selectTList) {
//                JSONObject jsonObject = JSON.parseObject(item);
//                if(!jsonObject.isEmpty())
//                {
//                    String key =  (String)jsonObject.get("key");
//                    STList.add(key);
//                }
//            }
//            if(STList.size()==0){
//                STList = null;
//            }
//        }
        if(!sorter.equals("")){
            String[] sorterlist = sorter.split("&&");
            sortField = sorterlist[0];
            sortOrder = sorterlist[1];
        }
        if(!timeInterval.equals("")){
            System.out.println(timeInterval+"timeInterval");
            String[] timeList = timeInterval.split("&&");
            System.out.println(timeList[0]+"timeList1"+timeList[1]+"timeList2");
            startDate = timeList[0];
            endDate = timeList[1];
        }
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Map<String, Object>> articleResult = blogMapper.articleVagueSearch(title, category, statusValue, commentStatusValue, startDate, endDate, sortField, sortOrder);
            PageInfo<Map<String, Object>> articles = new PageInfo<>(articleResult);
            articleObj.put("totalNum", articles.getTotal()); //总记录数目
            articleObj.put("pages", articles.getPages()); //总页数
            articleObj.put("pageNum", articles.getPageNum()); //当前页
            articleObj.put("pagesSize", articles.getSize()); //每页的数量
            Iterator<Map<String, Object>> iterator = articleResult.iterator();
            if(!tagList.equals("")){
                 while (iterator.hasNext()){
                     Map<String, Object> next  = iterator.next();
                     List<Tag> rTagList = (List<Tag>)next.get("blogTagsList");
                     boolean tagPos = false;
                     for(int i = 0;i<rTagList.size();i++){
//                         System.out.println(rTagList.get(i).getTagName()+":"+rTagList.get(i).getTagName().indexOf(tagList)+":"+tagList);
                         if(tagList.indexOf(rTagList.get(i).getTagName())!=-1)
                         {
                             tagPos= true;
                             break;
                         }
                     }
                     if(!tagPos)
                     {
                         iterator.remove();
                     }
                 }
            }
            articleObj.put("data", datafilter.Articlefilter(articleResult));
            DataMap objectDataMap = DataMap.success().setData(articleObj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            System.out.println(e+"articleSearchcateVagueSearch");
            DataMap searchfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchfail;
        }
        finally {
            PageHelper.clearPage();
        }



    }

    @Override
    public JSONObject getArticleNum() {
        try{
            JSONObject articleObj = new JSONObject();
            int bNum = blogMapper.selectBlogNum();
            articleObj.put("name","article");
            articleObj.put("Num",bNum);
            return articleObj;
        }
        catch (Exception e){
            System.out.println(e+"getArticleNum");
            return null;
        }

    }

    @Override
    public DataMap articleCanlder(String year) {
        try{
            List<Map<String, Object>> canlderMaps = blogMapper.calendarArticle(year);
            DataMap canlderMap = DataMap.success().setData(canlderMaps);
            return canlderMap;
        }
        catch (Exception e)
        {
            DataMap canlderFail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return canlderFail;
        }
    }


}

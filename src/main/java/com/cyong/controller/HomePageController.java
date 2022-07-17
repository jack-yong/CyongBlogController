package com.cyong.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.service.*;
import com.cyong.utils.DataMap;
import com.cyong.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.controller
 * @Author: cyong
 * @CreateTime: 2022-07-16 14:36
 * @Description: 展示页面的控制层
 */
@Controller
@Slf4j
@RequestMapping("/homepage")
public class HomePageController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LeaveMessageService leaveMessageService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private  DailySpeechService dailySpeechService;

    @Autowired
    private  UserService userService;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private DevLogService devLogService;

    @RequestMapping("/showdata")
    @ResponseBody
     public  String Showdata(){
        try{
            JSONArray showArray= new JSONArray();

            JSONObject articleNum = articleService.getArticleNum();
            JSONObject categoryNum = categoryService.getCategoryNum();
            JSONObject tagNums = tagService.getTagNums();
            JSONObject commentCount = commentService.getCommentCount();
            JSONObject lmCount = leaveMessageService.getLMCount();
            JSONObject linkCount = linkService.getLinkCount();
            JSONObject dsCount = dailySpeechService.getDSCount();
            JSONObject userNum = userService.getUserNum();
            JSONObject portfolioCount = portfolioService.getPortfolioCount();
            JSONObject dlCount = devLogService.getDLCount();
            showArray.add(articleNum);
            showArray.add(categoryNum);
            showArray.add(tagNums);
            showArray.add(commentCount);
            showArray.add(lmCount);
            showArray.add(linkCount);
            showArray.add(dsCount);
            showArray.add(userNum);
            showArray.add(portfolioCount);
            showArray.add(dlCount);
            DataMap showDataMap = DataMap.success().setData(showArray);
            return JsonResult.build(showDataMap).toJSON();

        }catch (Exception e)
        {
            log.error("get count happened exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }


    @RequestMapping("/articletype")
    @ResponseBody
    public String articleType(@RequestParam(name ="aType") String aType)
    {
        try{
            switch (aType)
            {
                case "category":
                    DataMap cateFollowMap = categoryService.categoryFollowsArticle();
                    return JsonResult.build(cateFollowMap).toJSON();
                case "tag":
                    DataMap tagFollowMap = tagService.tagFollowsArticle();
                    return JsonResult.build(tagFollowMap).toJSON();
            }
        }
        catch (Exception e)
        {
            log.error("get articleType happened exception", e);
        }
        return  JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

    @RequestMapping("/canlder")
    @ResponseBody
    public String canlder(@RequestParam(name ="year") String year)
    {
        try{
            DataMap dataMap = articleService.articleCanlder(year);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("get canlder happened expection",e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }








}

package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.TagService;
import com.cyong.utils.DataMap;
import com.cyong.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.controller
 * @Author: cyong
 * @CreateTime: 2022-07-01 15:58
 * @Description: 标签的控制层
 */
//下面的注解是保证返回
@RestController
@Slf4j
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/tag/vaguesearch")
    @ResponseBody
    public String tagVagueSearch(@RequestParam(name ="tagName",defaultValue = "") String tagName,
                                 @RequestParam(name ="sorter",defaultValue = "") String sorter,
                                 @RequestParam(name ="filters",defaultValue = "") String filters,
                                 @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                                 @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
        try{
//            System.out.println(tagName+sorter+filters+pageSize+pageNow);
            DataMap dataMap = tagService.tagVagueSearch(tagName, pageSize, pageNow,sorter,filters);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            System.out.println(e+"eee");
            log.error("tag vaguesearch get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();

    }

    @RequestMapping("/tag/searchAll")
    public String tagsearchAll(){
        try{
            DataMap dataMap = tagService.searchAllTags();
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("tag searchAll get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }


    @RequestMapping("/tag/add")
    @ResponseBody
    public String tagAdd(@RequestParam(name ="tagname") String tagName,
                         @RequestParam(name ="tagColor") String tagColor)
    {
        try{
            DataMap dataMap = tagService.addTag(tagName,tagColor);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e){
            log.error("add tag get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}

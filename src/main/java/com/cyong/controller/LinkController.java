package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.LinkService;
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
 * @CreateTime: 2022-07-20 13:30
 * @Description: 友链控制层业务逻辑
 */

@Controller
@Slf4j
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;


    @RequestMapping("/add")
    @ResponseBody
    public String  linkAdd(@RequestParam(name = "linktitle" ) String linkTitle,
                           @RequestParam(name = "linkurl" ) String linkUrl,
                           @RequestParam(name = "linkdesc" ) String linkDesc,
                           @RequestParam(name = "linktype") int linkType,
                           @RequestParam(name = "linkimg",defaultValue = "") String linkImage)
    {
        try{
            DataMap dataMap = linkService.addLink(linkImage, linkTitle, linkDesc, linkUrl, linkType);
            return  JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("Controller: LinkController","func:linkAdd",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public String linkSearch(@RequestParam(name = "linkkey",defaultValue = "") String linkKey,
                             @RequestParam(name = "sorter",defaultValue = "") String sorter,
                             @RequestParam(name ="filters",defaultValue = "") String filters,
                             @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                             @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
        try{
            DataMap dataMap = linkService.linkVagueSearch(linkKey, pageSize, pageNow, sorter, filters);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("Controller: linkSearch","func:linkSearch",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }

    @RequestMapping("/all")
    @ResponseBody
    public String linkAll()
    {
        try{
            DataMap dataMap = linkService.linkSearchAll();
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("Controller: linkSearch","func:linkSearch",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }

}

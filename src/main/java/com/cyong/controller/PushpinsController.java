package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.DailySpeechService;
import com.cyong.utils.DataMap;
import com.cyong.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.snmp.jvminstr.JvmOSImpl;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.controller
 * @Author: cyong
 * @CreateTime: 2022-07-20 09:55
 * @Description: 日常说说的控制层业务逻辑
 */

@Controller
@Slf4j
@RequestMapping("/pushpins")
public class PushpinsController {

    @Autowired
    private DailySpeechService dailySpeechService;


    @RequestMapping("/search")
    @ResponseBody
    public String pushpinsSearch(@RequestParam(name="pushpinsContent",defaultValue = "") String pushpinsContent,
                                 @RequestParam(name = "sorter",defaultValue = "") String sorter,
                                 @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                                 @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
       try{
           DataMap dataMap = dailySpeechService.vagueSearchByDSContent(pushpinsContent, pageNow, pageSize, sorter);
            return JsonResult.build(dataMap).toJSON();
       }
       catch (Exception e)
       {
           log.error("pushpinsSearch happend errror:",e);
           return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
       }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String pushpinsAdd(@RequestParam(name = "pushpinsContent") String pushpinsContent,
                              @RequestParam(name="pushpinsImage",defaultValue = "") String pushpinsImage)
    {
        try{

            DataMap dataMap = dailySpeechService.dsAdd(pushpinsContent, pushpinsImage);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e){
            log.error("add pushpins get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String pushpinsAll()
    {
        try{
            DataMap allDailySpeech = dailySpeechService.getAllDailySpeech();
            return JsonResult.build(allDailySpeech).toJSON();
        }
        catch (Exception e)
        {
            log.error("get all pushpins error",e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}

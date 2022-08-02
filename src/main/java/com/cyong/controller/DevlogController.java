package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.DevLogService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
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
 * @CreateTime: 2022-07-21 11:01
 * @Description: 开发日志的控制层处理逻辑
 */

@Controller
@Slf4j
@RequestMapping("/devlog")
public class DevlogController {
    @Autowired
    private DevLogService devLogService;


    @RequestMapping("/search")
    @ResponseBody
    public String devLogSearch(@RequestParam(name = "devlogkey",defaultValue = "") String devlogkey,
                               @RequestParam(name = "sorter",defaultValue = "") String sorter,
                               @RequestParam(name ="filters",defaultValue = "") String filters,
                               @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                               @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
        try
        {
            DataMap dataMap = devLogService.vagueSearchDevlog(devlogkey, pageSize, pageNow, sorter, filters);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("Controller : DevLogController","func: devLogSearch",e);
            return  JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String devLogAdd(@RequestParam(name = "devlogtitle") String devlogtitle,
                            @RequestParam(name = "devlogtype") int devlogtype,
                            @RequestParam(name = "devlogcontent") String devlogcontent)
    {
        try
        {
            DataMap dataMap = devLogService.addDevlog(devlogtitle, devlogcontent, devlogtype);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("Controller : DevLogController","func: devLogAdd",e);
            return  JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();

        }
    }

    @RequestMapping("/all")
    @ResponseBody
    public String devLogAll()
    {
        try{
            DataMap allDevlog = devLogService.getAllDevlog();
            return JsonResult.build(allDevlog).toJSON();
        }
        catch (Exception e)
        {
            log.error("get all devLog error",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }
}

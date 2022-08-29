package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.LinkService;
import com.cyong.service.PortfolioService;
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
 * @CreateTime: 2022-08-29 10:12
 * @Description: Portfolio控制层业务逻辑
 */

@Controller
@Slf4j
@RequestMapping("/portfolio")
public class PortfolioControler {
    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping("/add")
    @ResponseBody
    public String  portfolioAdd(@RequestParam(name = "portfoliotitle" ) String portfoliotitle,
                                @RequestParam(name = "portfolioContent") String portfolioContent,
                                @RequestParam(name = "portfoliourl") String portfoliourl,
                                @RequestParam(name = "portfolioimage",defaultValue = "") String portfolioimage)
    {
        try{
            DataMap dataMap = portfolioService.addPortfolio(portfoliotitle, portfolioContent, portfolioimage,portfoliourl);
            return  JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("func:portfolioAdd",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }


    @RequestMapping("/all")
    @ResponseBody
    public String  portfolioAll()
    {
        try{
            DataMap dataMap = portfolioService.searchAllPortfolio();
            return  JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("func:portfolioAll",e);
            return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
        }
    }
}


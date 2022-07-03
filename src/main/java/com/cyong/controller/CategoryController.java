package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.CategoryService;
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
 * @CreateTime: 2022-05-12 21:44
 * @Description: category控制层相关代码
 */
@Controller
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/search")
    @ResponseBody
    public String categorysearch(@RequestParam(name ="cateName",defaultValue = "") String cateName,
                                 @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                                 @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
        try{
            DataMap dataMap = categoryService.cateVagueSearch(cateName,pageSize,pageNow);
            return JsonResult.build(dataMap).toJSON();
        }catch (Exception e){
            log.error("search category by name happened exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();

    }

    @RequestMapping("/category/searchAll")
    @ResponseBody
    public  String categorysearchAll()
    {
        try{
            DataMap dataMap = categoryService.searchAllCategory();
            return JsonResult.build(dataMap).toJSON();
        }catch (Exception e){
            log.error("search all category  happened exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }


    @RequestMapping("/category/add")
    @ResponseBody
    public String categoryAdd(@RequestParam(name ="cateName") String cateName,
                              @RequestParam(name ="cateImgUrl",defaultValue = "") String cateImgUrl)
    {
        try{
            DataMap dataMap = categoryService.addCategory(cateName, "");
            return  JsonResult.build(dataMap).toJSON();
        }catch (Exception e)
        {
            log.error("add category happened exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}

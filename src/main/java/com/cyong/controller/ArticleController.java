package com.cyong.controller;



import com.cyong.constant.CodeType;
import com.cyong.service.ArticleService;
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
 * @CreateTime: 2022-07-02 15:24
 * @Description: 文章的控制层业务处理逻辑
 */

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article/add")
    @ResponseBody
    String articleAdd(@RequestParam(name ="title") String title,
                      @RequestParam(name ="content") String content,
                      @RequestParam(name ="categoryid") int category,
                      @RequestParam(name = "tags") String tagList,
                      @RequestParam(name ="status") String status,
                      @RequestParam(name ="coverImage",defaultValue = "") String coverImage){

        try{
            int numstatus = Integer.parseInt(status);
            DataMap dataMap = articleService.addArticle(title, content, category,tagList,coverImage,numstatus);
            return  JsonResult.build(dataMap).toJSON();


        }catch (Exception e)
        {
            log.error("add article happened exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }
}

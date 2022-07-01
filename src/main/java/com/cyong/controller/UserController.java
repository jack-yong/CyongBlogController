package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.*;
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
 * @CreateTime: 2022-03-11 09:29
 * @Description: 用户相关的控制层业务逻辑
 */
//下面的注解是保证返回
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/vaguesearch")
    @ResponseBody
    public String vagueSearch(@RequestParam(name ="searchName",defaultValue = "") String searchname,
                       @RequestParam(name ="pageSize",defaultValue = "10") int pageSize,
                       @RequestParam(name ="page",defaultValue = "1") int pageNow)
    {
        try{
//            System.out.println(searchname+pageSize);
            DataMap dataMap = userService.userVagueSearch(searchname, pageSize, pageNow);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e)
        {
            log.error("user vaguesearch get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();

    }



}

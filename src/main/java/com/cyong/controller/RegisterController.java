package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.service.UserService;
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
 * @CreateTime: 2022-03-19 21:46
 * @Description: 注册控制器
 */
//下面的注解是保证返回
@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/register")
    @ResponseBody
    public String userRegister(@RequestParam(name ="username") String username,
                               @RequestParam(name="password") String password,
                               @RequestParam(name="email") String email,
                               @RequestParam(name="phone") String phone){
        try{
            DataMap dataMap = userService.insert(username, password, email, phone);
            return JsonResult.build(dataMap).toJSON();
        }
        catch (Exception e){
            log.error("login get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}

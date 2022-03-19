package com.cyong.controller;

import com.cyong.service.*;
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
    UserService userService;




}

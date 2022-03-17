package com.cyong.controller;

import com.cyong.constant.CodeType;
import com.cyong.model.AccessTokenDTO;
import com.cyong.model.GithubUser;
import com.cyong.model.User;
import com.cyong.service.UserService;
import com.cyong.utils.DataMap;
import com.cyong.utils.GithubProvider;
import com.cyong.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.controller
 * @Author: cyong
 * @CreateTime: 2022-03-11 09:44
 * @Description: 登录的控制层呢业务逻辑
 */

@Controller
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name ="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("35ac9daad4c0a9105edc");
        accessTokenDTO.setClient_secret("b707e864e9466ad116fcd5cbfceed751598dc8a2");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        return user.toString();
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public String userlogin(@RequestParam(name ="username") String username,
                           @RequestParam(name="password") String password)
    {
        try{
            DataMap dataMap = userService.userLoginVerify(username, password);
            return JsonResult.build(dataMap).toJSON();
        }catch (Exception e){
            log.error("login get an  exception", e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();

    }


}

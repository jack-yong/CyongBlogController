package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.constant.StringConst;
import com.cyong.dao.UserMapper;
import com.cyong.model.User;
import com.cyong.service.UserService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2021-11-22 11:22
 * @Description: user服务层具体业务逻辑
 */
@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    private  Datafilter datafilter;

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public String findUsernameById(int id) {
        return userMapper.findUsernameById(id);
    }

    @Override
    public DataMap insert(String username, String password, String email, String phone) {
        //随机生成图片呢的地址
        String imgDefaultUrl = "https://joeschmoe.io/api/v1/random";
        String trimBlankUsername = username.trim().replaceAll(" ", StringConst.BLANK);
        Date currenttime = new Date();
        if(trimBlankUsername.length() > StringConst.USERNAME_MAX_LENGTH || StringConst.BLANK.equals(trimBlankUsername)){
            return DataMap.fail(CodeType.USERNAME_FORMAT_ERROR);
        }
        if(usernameIsExist(trimBlankUsername)){
            return DataMap.fail(CodeType.USER_NAME_EXIST);
        }
        User user =new User(trimBlankUsername,password, email,phone,imgDefaultUrl,"user",currenttime);
        System.out.println(user);
        int insert = userMapper.insert(user);
        return DataMap.success();
    }

    @Override
    public int findUserIdByPhone(String phone) {
        return 0;
    }

    @Override
    public String findPhoneByUsername(String username) {
        return null;
    }

    @Override
    public int findIdByUsername(String username) {
        return 0;
    }

    @Override
    public User findUserByUsername(String username) {

        return userMapper.findUserByUsername(username);
    }

    @Override
    public void updateRecentlyLanded(String username, String recentlyLanded) {

    }

    @Override
    public boolean usernameIsExist(String username) {
        User userByUsername = userMapper.findUserByUsername(username);
        return userByUsername!=null;
    }

    @Override
    public void updateAvatarImgUrlById(String avatarImgUrl, int id) {

    }

    @Override
    public DataMap getHeadPortraitUrl(int id) {
        return null;
    }

    @Override
    public DataMap getUserPersonalInfoByUsername(String username) {
        return null;
    }

    @Override
    public DataMap savePersonalDate(User user, String username) {
        return null;
    }

    @Override
    public int countUserNum() {
        return 0;
    }

    @Override
    public DataMap userLoginVerify(String username, String password) {
        User userByUsername = userMapper.findUserByUsername(username);
        if(userByUsername!=null){
            if(password.equals(userByUsername.getUserPassword())){
                DataMap data = DataMap.success().setData(userByUsername);
                return data;
            }
            else{
                DataMap data = DataMap.fail(CodeType.USER_PSASSWORD_ERROR);
                return data;
            }
        }else{
            DataMap data = DataMap.fail(CodeType.USER_NOT_EXIT);
            return data;
        }

    }

    @Override
    public DataMap userVagueSearch(String userName, int pageSize, int pageNum) {
        JSONObject userobi = new JSONObject();
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<User> userResults = userMapper.vagueSearchByUserName(userName);
            PageInfo<User> users = new PageInfo<>(userResults);
            userobi.put("totalNum",users.getTotal());
            userobi.put("pages",users.getPages());
            userobi.put("pageNum",users.getPageNum());
            userobi.put("pagesSize",users.getPageSize());
            userobi.put("data", datafilter.Userfilter(userResults));
            DataMap dataMap = DataMap.success().setData(userobi);
            return  dataMap;
        }
        catch (Exception e)
        {
            DataMap searchfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return searchfail;
        }
        finally {
            PageHelper.clearPage();
        }
    }
}

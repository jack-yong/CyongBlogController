package com.cyong.service.impl;

import com.cyong.constant.CodeType;
import com.cyong.constant.StringConst;
import com.cyong.dao.UserMapper;
import com.cyong.model.User;
import com.cyong.service.UserService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(trimBlankUsername.length() > StringConst.USERNAME_MAX_LENGTH || StringConst.BLANK.equals(trimBlankUsername)){
            return DataMap.fail(CodeType.USERNAME_FORMAT_ERROR);
        }
        if(usernameIsExist(trimBlankUsername)){
            return DataMap.fail(CodeType.USER_NAME_EXIST);
        }
        User user =new User(trimBlankUsername,password, email,phone,imgDefaultUrl,"user");
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
}

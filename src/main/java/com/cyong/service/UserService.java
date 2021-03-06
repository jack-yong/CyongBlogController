package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.model.User;
import com.cyong.utils.DataMap;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service
 * @Author: cyong
 * @CreateTime: 2021-11-22 11:21
 * @Description: user服务层业务逻辑
 */
public interface UserService {
    /**
     *  通过手机号查找注册用户
     * @param phone 手机号
     * @return 用户
     */
    User findUserByPhone(String phone);

    /**
     * 通过id查找用户名
     * @param id
     * @return
     */
    String findUsernameById(int id);

    /**
     * 注册用户
     */
    @Transactional
    DataMap insert(String username,String password,String email,String phone);

    /**
     * 通过手机号查找用户id
     * @param phone 手机号
     * @return 用户id
     */
    int findUserIdByPhone(String phone);


    /**
     * 通过用户名获得手机号
     * @param username 用户名
     * @return 手机号
     */
    String findPhoneByUsername(String username);

    /**
     * 通过用户名查找id
     * @param username
     * @return
     */
    int findIdByUsername(String username);

    /**
     * 通过用户名查找用户信息
     * @param username 手机号
     * @return 用户名
     */
    User findUserByUsername(String username);

    /**
     * 更新最近登录时间
     * @param username 用户名
     * @param recentlyLanded 最近登录时间
     */
    void updateRecentlyLanded(String username, String recentlyLanded);

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return true--存在  false--不存在
     */
    boolean usernameIsExist(String username);

    /**
     * 更改头像
     * @param avatarImgUrl 头像地址
     */
    @Transactional
    void updateAvatarImgUrlById(String avatarImgUrl, int id);

    /**
     * 获得头像url
     */
    DataMap getHeadPortraitUrl(int id);


    /**
     * 获得用户个人信息
     * @return
     */
    DataMap getUserPersonalInfoByUsername(String username);

    /**
     * 保存用户个人信息
     * @param user 个人信息
     * @param username 当前更改的用户
     * @return
     */
    @Transactional
    DataMap savePersonalDate(User user, String username);


    /**
     * 统计总用户量
     * @return
     */
    int countUserNum();

    DataMap userLoginVerify(String username,String password);

    DataMap userVagueSearch(String userName,int pageSize,int pageNum,String sorter,String filters);


    JSONObject getUserNum();


}

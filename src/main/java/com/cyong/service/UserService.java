package com.cyong.service;

import com.cyong.model.User;

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
}

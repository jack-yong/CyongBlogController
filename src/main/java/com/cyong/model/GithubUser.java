package com.cyong.model;

import lombok.Data;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.model
 * @Author: cyong
 * @CreateTime: 2022-03-14 11:03
 * @Description: 接收github用户的信息
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}

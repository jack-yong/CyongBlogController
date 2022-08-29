package com.cyong.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.model
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:47
 * @Description: 作品集实体类
 */
@Data
public class Portfolio {
    private Integer portfolioID;
    private String portfolioTitle;
    private  String portfolioDescribe;
    private  String portfolioImgUrl;
    private Date  portfolioDate;
    private String portfolioUrl;
}

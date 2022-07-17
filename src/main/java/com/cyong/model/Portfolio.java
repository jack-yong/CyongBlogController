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
    private Integer PortfolioID;
    private String PortfolioTitle;
    private  String PortfolioDescribe;
    private  String PortfolioImgUrl;
    private Date  PortfolioDate;
}

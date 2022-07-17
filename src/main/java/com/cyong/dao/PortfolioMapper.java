package com.cyong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.dao
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:53
 * @Description: 作品集mapper层
 */
@Mapper
@Repository
public interface PortfolioMapper {
    int selectPortfolioNum();
}

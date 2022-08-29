package com.cyong.dao;

import com.cyong.model.Link;
import com.cyong.model.Portfolio;
import com.cyong.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Portfolio>  getAllPortfolios();

    int insert(Portfolio record);

}

package com.cyong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.dao
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:50
 * @Description: 开发日志mapper层
 */
@Mapper
@Repository
public interface DevLogMapper {

    int selectDevLogNum();
}

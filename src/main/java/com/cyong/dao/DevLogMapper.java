package com.cyong.dao;

import com.cyong.model.DevLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    int insertSelective(DevLog devLog);

    List<DevLog> vagueSearchDL(String searchKey,String sortField,String sortOrder ,List<String> devLogKinds);

    List<DevLog> getAllDL();

}

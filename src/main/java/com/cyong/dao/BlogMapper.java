package com.cyong.dao;

import com.cyong.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int deleteByPrimaryKey(Long blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    Blog selectByPrimaryKey(Long blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_blog
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKey(Blog record);

    int selectBlogNum();

    List<Map<String,Object>> articleVagueSearch(String title, int categoryId,String status, String commentStatus, String startDate, String endDate, String sortField, String sortOrder);

    List<Map<String,Object>> calendarArticle(String year);
}
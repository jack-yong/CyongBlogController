package com.cyong.dao;

import com.cyong.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int deleteByPrimaryKey(Integer configId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insert(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insertSelective(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    Config selectByPrimaryKey(Integer configId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKeySelective(Config record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_config
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKey(Config record);
}
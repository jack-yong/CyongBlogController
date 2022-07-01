package com.cyong.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Category {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String categoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_icon
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String categoryIcon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer categoryRank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte categoryIsDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_category.category_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    //JSONField比JsonFormat好用
    private Date categoryCreateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_id
     *
     * @return the value of tb_category.category_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_id
     *
     * @param categoryId the value for tb_category.category_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_name
     *
     * @return the value of tb_category.category_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_name
     *
     * @param categoryName the value for tb_category.category_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_icon
     *
     * @return the value of tb_category.category_icon
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_icon
     *
     * @param categoryIcon the value for tb_category.category_icon
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_rank
     *
     * @return the value of tb_category.category_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getCategoryRank() {
        return categoryRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_rank
     *
     * @param categoryRank the value for tb_category.category_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_is_deleted
     *
     * @return the value of tb_category.category_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getCategoryIsDeleted() {
        return categoryIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_is_deleted
     *
     * @param categoryIsDeleted the value for tb_category.category_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryIsDeleted(Byte categoryIsDeleted) {
        this.categoryIsDeleted = categoryIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_category.category_create_time
     *
     * @return the value of tb_category.category_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getCategoryCreateTime() {
        return categoryCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_category.category_create_time
     *
     * @param categoryCreateTime the value for tb_category.category_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCategoryCreateTime(Date categoryCreateTime) {
        this.categoryCreateTime = categoryCreateTime;
    }
}
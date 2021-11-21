package com.cyong.model;

import java.util.Date;

public class Tag {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag.tag_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer tagId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag.tag_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String tagName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag.tag_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte tagIsDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_tag.tag_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date tagCreateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag.tag_id
     *
     * @return the value of tb_tag.tag_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag.tag_id
     *
     * @param tagId the value for tb_tag.tag_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag.tag_name
     *
     * @return the value of tb_tag.tag_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag.tag_name
     *
     * @param tagName the value for tb_tag.tag_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag.tag_is_deleted
     *
     * @return the value of tb_tag.tag_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getTagIsDeleted() {
        return tagIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag.tag_is_deleted
     *
     * @param tagIsDeleted the value for tb_tag.tag_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setTagIsDeleted(Byte tagIsDeleted) {
        this.tagIsDeleted = tagIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_tag.tag_create_time
     *
     * @return the value of tb_tag.tag_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getTagCreateTime() {
        return tagCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_tag.tag_create_time
     *
     * @param tagCreateTime the value for tb_tag.tag_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setTagCreateTime(Date tagCreateTime) {
        this.tagCreateTime = tagCreateTime;
    }
}
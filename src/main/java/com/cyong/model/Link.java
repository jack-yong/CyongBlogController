package com.cyong.model;

import java.util.Date;

public class Link {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer linkId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_type
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte linkType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String linkName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_url
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String linkUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_description
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String linkDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer linkRank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte linkIsDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_link.link_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date linkCreateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_id
     *
     * @return the value of tb_link.link_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_id
     *
     * @param linkId the value for tb_link.link_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_type
     *
     * @return the value of tb_link.link_type
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getLinkType() {
        return linkType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_type
     *
     * @param linkType the value for tb_link.link_type
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkType(Byte linkType) {
        this.linkType = linkType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_name
     *
     * @return the value of tb_link.link_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_name
     *
     * @param linkName the value for tb_link.link_name
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_url
     *
     * @return the value of tb_link.link_url
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_url
     *
     * @param linkUrl the value for tb_link.link_url
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_description
     *
     * @return the value of tb_link.link_description
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getLinkDescription() {
        return linkDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_description
     *
     * @param linkDescription the value for tb_link.link_description
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null ? null : linkDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_rank
     *
     * @return the value of tb_link.link_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getLinkRank() {
        return linkRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_rank
     *
     * @param linkRank the value for tb_link.link_rank
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_is_deleted
     *
     * @return the value of tb_link.link_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getLinkIsDeleted() {
        return linkIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_is_deleted
     *
     * @param linkIsDeleted the value for tb_link.link_is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkIsDeleted(Byte linkIsDeleted) {
        this.linkIsDeleted = linkIsDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_link.link_create_time
     *
     * @return the value of tb_link.link_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getLinkCreateTime() {
        return linkCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_link.link_create_time
     *
     * @param linkCreateTime the value for tb_link.link_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setLinkCreateTime(Date linkCreateTime) {
        this.linkCreateTime = linkCreateTime;
    }
}
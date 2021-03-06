package com.cyong.model;

import java.util.Date;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Long commentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_blog_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Long commentBlogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_answererid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Long commentAnswererid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_fatherid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Long commentFatherid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_body
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String commentBody;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date commentCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.reply_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date replyCreateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_status
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte commentStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Byte isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_id
     *
     * @return the value of tb_comment.comment_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_id
     *
     * @param commentId the value for tb_comment.comment_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_blog_id
     *
     * @return the value of tb_comment.comment_blog_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Long getCommentBlogId() {
        return commentBlogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_blog_id
     *
     * @param commentBlogId the value for tb_comment.comment_blog_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentBlogId(Long commentBlogId) {
        this.commentBlogId = commentBlogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_answererid
     *
     * @return the value of tb_comment.comment_answererid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Long getCommentAnswererid() {
        return commentAnswererid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_answererid
     *
     * @param commentAnswererid the value for tb_comment.comment_answererid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentAnswererid(Long commentAnswererid) {
        this.commentAnswererid = commentAnswererid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_fatherid
     *
     * @return the value of tb_comment.comment_fatherid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Long getCommentFatherid() {
        return commentFatherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_fatherid
     *
     * @param commentFatherid the value for tb_comment.comment_fatherid
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentFatherid(Long commentFatherid) {
        this.commentFatherid = commentFatherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_body
     *
     * @return the value of tb_comment.comment_body
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getCommentBody() {
        return commentBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_body
     *
     * @param commentBody the value for tb_comment.comment_body
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_create_time
     *
     * @return the value of tb_comment.comment_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_create_time
     *
     * @param commentCreateTime the value for tb_comment.comment_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.reply_create_time
     *
     * @return the value of tb_comment.reply_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.reply_create_time
     *
     * @param replyCreateTime the value for tb_comment.reply_create_time
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_status
     *
     * @return the value of tb_comment.comment_status
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getCommentStatus() {
        return commentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_status
     *
     * @param commentStatus the value for tb_comment.comment_status
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.is_deleted
     *
     * @return the value of tb_comment.is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.is_deleted
     *
     * @param isDeleted the value for tb_comment.is_deleted
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
package com.cyong.model;

import java.util.Date;



public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_phone
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_nickname
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userNickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_password
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_trueName
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userTruename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_birthday
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userBirthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_email
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_avatarImgUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userAvatarimgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_recentlyLanded
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date userRecentlylanded;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_role
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String userRole;

    public User() {
    }

    public User(String userNickname, String userPassword,  String userEmail, String userPhone, String userAvatarimgurl, String userRole,Date Recentlylanded) {
        this.userPhone = userPhone;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userAvatarimgurl = userAvatarimgurl;
        this.userRole = userRole;
        this.userRecentlylanded = Recentlylanded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_id
     *
     * @return the value of tb_user.user_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_id
     *
     * @param userId the value for tb_user.user_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_phone
     *
     * @return the value of tb_user.user_phone
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_phone
     *
     * @param userPhone the value for tb_user.user_phone
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_nickname
     *
     * @return the value of tb_user.user_nickname
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_nickname
     *
     * @param userNickname the value for tb_user.user_nickname
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_password
     *
     * @return the value of tb_user.user_password
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_password
     *
     * @param userPassword the value for tb_user.user_password
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_trueName
     *
     * @return the value of tb_user.user_trueName
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserTruename() {
        return userTruename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_trueName
     *
     * @param userTruename the value for tb_user.user_trueName
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserTruename(String userTruename) {
        this.userTruename = userTruename == null ? null : userTruename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_birthday
     *
     * @return the value of tb_user.user_birthday
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserBirthday() {
        return userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_birthday
     *
     * @param userBirthday the value for tb_user.user_birthday
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_email
     *
     * @return the value of tb_user.user_email
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_email
     *
     * @param userEmail the value for tb_user.user_email
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_avatarImgUrl
     *
     * @return the value of tb_user.user_avatarImgUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserAvatarimgurl() {
        return userAvatarimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_avatarImgUrl
     *
     * @param userAvatarimgurl the value for tb_user.user_avatarImgUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserAvatarimgurl(String userAvatarimgurl) {
        this.userAvatarimgurl = userAvatarimgurl == null ? null : userAvatarimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_recentlyLanded
     *
     * @return the value of tb_user.user_recentlyLanded
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getUserRecentlylanded() {
        return userRecentlylanded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_recentlyLanded
     *
     * @param userRecentlylanded the value for tb_user.user_recentlyLanded
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserRecentlylanded(Date userRecentlylanded) {
        this.userRecentlylanded = userRecentlylanded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_role
     *
     * @return the value of tb_user.user_role
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_role
     *
     * @param userRole the value for tb_user.user_role
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPhone='" + userPhone + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userTruename='" + userTruename + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAvatarimgurl='" + userAvatarimgurl + '\'' +
                ", userRecentlylanded=" + userRecentlylanded +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
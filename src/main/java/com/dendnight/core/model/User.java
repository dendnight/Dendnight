package com.dendnight.core.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.nickname
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.mobile
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_type
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private String userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.created_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.updated_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.updated_by
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private Integer updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.deleted
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    private Integer deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.nickname
     *
     * @return the value of t_user.nickname
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.nickname
     *
     * @param nickname the value for t_user.nickname
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.mobile
     *
     * @return the value of t_user.mobile
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.mobile
     *
     * @param mobile the value for t_user.mobile
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_type
     *
     * @return the value of t_user.user_type
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_type
     *
     * @param userType the value for t_user.user_type
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.created_time
     *
     * @return the value of t_user.created_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.created_time
     *
     * @param createdTime the value for t_user.created_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.updated_time
     *
     * @return the value of t_user.updated_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.updated_time
     *
     * @param updatedTime the value for t_user.updated_time
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.updated_by
     *
     * @return the value of t_user.updated_by
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.updated_by
     *
     * @param updatedBy the value for t_user.updated_by
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.deleted
     *
     * @return the value of t_user.deleted
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.deleted
     *
     * @param deleted the value for t_user.deleted
     *
     * @mbggenerated Wed Feb 19 23:32:04 CST 2014
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
package com.cyong.model;

import java.util.Date;

public class DailySpeech {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_daily_speech.dspeech_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Integer dspeechId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_daily_speech.dspeech_picsUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String dspeechPicsurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_daily_speech.dspeech_publishDate
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private Date dspeechPublishdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_daily_speech.dspeech_content
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    private String dspeechContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_daily_speech.dspeech_id
     *
     * @return the value of tb_daily_speech.dspeech_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Integer getDspeechId() {
        return dspeechId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_daily_speech.dspeech_id
     *
     * @param dspeechId the value for tb_daily_speech.dspeech_id
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setDspeechId(Integer dspeechId) {
        this.dspeechId = dspeechId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_daily_speech.dspeech_picsUrl
     *
     * @return the value of tb_daily_speech.dspeech_picsUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getDspeechPicsurl() {
        return dspeechPicsurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_daily_speech.dspeech_picsUrl
     *
     * @param dspeechPicsurl the value for tb_daily_speech.dspeech_picsUrl
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setDspeechPicsurl(String dspeechPicsurl) {
        this.dspeechPicsurl = dspeechPicsurl == null ? null : dspeechPicsurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_daily_speech.dspeech_publishDate
     *
     * @return the value of tb_daily_speech.dspeech_publishDate
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public Date getDspeechPublishdate() {
        return dspeechPublishdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_daily_speech.dspeech_publishDate
     *
     * @param dspeechPublishdate the value for tb_daily_speech.dspeech_publishDate
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setDspeechPublishdate(Date dspeechPublishdate) {
        this.dspeechPublishdate = dspeechPublishdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_daily_speech.dspeech_content
     *
     * @return the value of tb_daily_speech.dspeech_content
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public String getDspeechContent() {
        return dspeechContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_daily_speech.dspeech_content
     *
     * @param dspeechContent the value for tb_daily_speech.dspeech_content
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    public void setDspeechContent(String dspeechContent) {
        this.dspeechContent = dspeechContent == null ? null : dspeechContent.trim();
    }
}
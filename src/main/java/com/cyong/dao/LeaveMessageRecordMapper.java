package com.cyong.dao;

import com.cyong.model.LeaveMessageRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LeaveMessageRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int deleteByPrimaryKey(Integer lmrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insert(LeaveMessageRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int insertSelective(LeaveMessageRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    LeaveMessageRecord selectByPrimaryKey(Integer lmrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKeySelective(LeaveMessageRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(LeaveMessageRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_leave_message_record
     *
     * @mbggenerated Mon Oct 25 11:12:50 CST 2021
     */
    int updateByPrimaryKey(LeaveMessageRecord record);


    int selectMessageNum();
}
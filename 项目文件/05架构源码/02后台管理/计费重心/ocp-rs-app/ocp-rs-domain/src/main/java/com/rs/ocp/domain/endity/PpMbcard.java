package com.rs.ocp.domain.endity;

public class PpMbcard {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pp_mbcard.mbcard_id
     *
     * @mbggenerated
     */
    private Integer mbcardId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pp_mbcard.mbcard_pid
     *
     * @mbggenerated
     */
    private Integer mbcardPid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pp_mbcard.mbcard_num
     *
     * @mbggenerated
     */
    private String mbcardNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pp_mbcard.mbcard_array
     *
     * @mbggenerated
     */
    private String mbcardArray;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pp_mbcard.mbcard_status
     *
     * @mbggenerated
     */
    private Integer mbcardStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_mbcard.mbcard_id
     *
     * @return the value of pp_mbcard.mbcard_id
     *
     * @mbggenerated
     */
    public Integer getMbcardId() {
        return mbcardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_mbcard.mbcard_id
     *
     * @param mbcardId the value for pp_mbcard.mbcard_id
     *
     * @mbggenerated
     */
    public void setMbcardId(Integer mbcardId) {
        this.mbcardId = mbcardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_mbcard.mbcard_pid
     *
     * @return the value of pp_mbcard.mbcard_pid
     *
     * @mbggenerated
     */
    public Integer getMbcardPid() {
        return mbcardPid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_mbcard.mbcard_pid
     *
     * @param mbcardPid the value for pp_mbcard.mbcard_pid
     *
     * @mbggenerated
     */
    public void setMbcardPid(Integer mbcardPid) {
        this.mbcardPid = mbcardPid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_mbcard.mbcard_num
     *
     * @return the value of pp_mbcard.mbcard_num
     *
     * @mbggenerated
     */
    public String getMbcardNum() {
        return mbcardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_mbcard.mbcard_num
     *
     * @param mbcardNum the value for pp_mbcard.mbcard_num
     *
     * @mbggenerated
     */
    public void setMbcardNum(String mbcardNum) {
        this.mbcardNum = mbcardNum == null ? null : mbcardNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_mbcard.mbcard_array
     *
     * @return the value of pp_mbcard.mbcard_array
     *
     * @mbggenerated
     */
    public String getMbcardArray() {
        return mbcardArray;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_mbcard.mbcard_array
     *
     * @param mbcardArray the value for pp_mbcard.mbcard_array
     *
     * @mbggenerated
     */
    public void setMbcardArray(String mbcardArray) {
        this.mbcardArray = mbcardArray == null ? null : mbcardArray.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_mbcard.mbcard_status
     *
     * @return the value of pp_mbcard.mbcard_status
     *
     * @mbggenerated
     */
    public Integer getMbcardStatus() {
        return mbcardStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_mbcard.mbcard_status
     *
     * @param mbcardStatus the value for pp_mbcard.mbcard_status
     *
     * @mbggenerated
     */
    public void setMbcardStatus(Integer mbcardStatus) {
        this.mbcardStatus = mbcardStatus;
    }
}
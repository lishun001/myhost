package com.rs.ocp.domain.mappers;

import com.rs.ocp.domain.endity.GameLoginsession;
import com.rs.ocp.domain.endity.GameLoginsessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameLoginsessionMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int countByExample(GameLoginsessionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int deleteByExample(GameLoginsessionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer sessionId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int insert(GameLoginsession record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int insertSelective(GameLoginsession record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    List<GameLoginsession> selectByExample(GameLoginsessionExample example);

    List<GameLoginsession> selectByExampleLimit1(GameLoginsessionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    GameLoginsession selectByPrimaryKey(Integer sessionId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") GameLoginsession record, @Param("example") GameLoginsessionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") GameLoginsession record, @Param("example") GameLoginsessionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GameLoginsession record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table game_loginsession
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GameLoginsession record);
}
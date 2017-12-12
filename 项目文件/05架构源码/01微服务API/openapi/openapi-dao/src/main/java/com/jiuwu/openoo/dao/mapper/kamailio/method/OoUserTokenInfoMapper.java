package com.jiuwu.openoo.dao.mapper.kamailio.method;

import java.util.Date;

import model.ApiMethod.UserTokenInfo;

public interface OoUserTokenInfoMapper {
	
	/**
	 * 根据token获取用户Id
	 * @param token
	 * @return
	 */
	public UserTokenInfo getUserTokenInfoByToken(String token);
	
	
	/**
	 * @FunName insertUserToken
	 * @description 插入用户token
	 * @param token
	 * @return 插入的条数
	 */
	public Integer insertUserToken(UserTokenInfo obj);
	
	/**
	 * @FunName updateToken
	 * @description 更新用户的Token
	 * @param token
	 * @return 插入的条数
	 */
	public Integer updateToken(UserTokenInfo obj);
	
	
	/**
	 * @FunName getLoginDateByUserId
	 * @description 获取token的更新时间（最后登录时间）
	 * @param userId 用户id
	 * @return Date 最后登录时间
	 * @author xiaoyong
	 * @createDate 2014-09-22
	 */
	public Date getLoginDateByUserId(String userId);
	
	
	
}

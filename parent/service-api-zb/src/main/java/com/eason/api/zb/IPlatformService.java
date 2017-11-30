package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;

/**
 * @apiDefine platform 三方平台API
 */
public interface IPlatformService {

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup platform
	 * @apiPermission Android/IOS
	 * @api {GET} /platform/media/get/{zbId} 获取media地址
	 * @apiName getMedia
	 *
	 *
	 * @apiDescription
	 * > 首次获取需要验证media流权限，获取的key存入缓存，调用视频流的接口，获取推/拉流地址</br>
	 *
	 * @apiSuccess {String} type  视频流类型
	 * @apiSuccess {String}  url   视频流地址
	 * @apiSuccess {String}  access_token   访问token
	 */
	public MediaResponseVo getMedia(Integer zbId, String token) throws ServiceException;


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup platform
	 * @apiPermission Android/IOS
	 * @api {GET} /platform/im/get/{zbId} 获取im地址
	 * @apiName getIM
	 *
	 *
	 * @apiDescription
	 * > 首次获取需要验证IM流权限，获取的key存入缓存，调用视频流的接口，获取推/拉流地址</br>
	 *
	 * @apiSuccess {String} type  即时通讯类型
	 * @apiSuccess {String}  url   即时通讯地址
	 * @apiSuccess {Integer}  port  即时通讯端口
	 * @apiSuccess {String}  access_token   访问token
	 */
	public IMResponseVo getIM(Integer zbId, String token) throws ServiceException;

}

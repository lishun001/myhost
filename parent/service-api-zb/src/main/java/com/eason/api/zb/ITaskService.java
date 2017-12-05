package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.StartPlayResponseVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;

import java.util.List;

/**
 * @apiDefine task 任务API
 */
public interface ITaskService {

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup task
	 * @apiPermission Android/IOS
	 * @api {GET} /task/resetTrySee  重置试看时间
	 * @apiName resetTrySee
	 *
	 * @apiDescription
	 * > 每天凌晨4点，重置试看</br>
	 * @apiSuccess {String} result 重置成功或者失败
	 *
	 */
	public String resetTrySee() throws ServiceException;



}

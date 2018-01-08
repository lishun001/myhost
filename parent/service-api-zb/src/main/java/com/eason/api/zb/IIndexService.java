package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.PageModel;
import com.eason.api.zb.vo.index.BannerResponseVo;
import com.eason.api.zb.vo.index.IndexResponseVo;
import com.eason.api.zb.vo.index.MsgNotificationResponseVo;

import java.util.List;

/**
 * @apiDefine index 直播首页API
 */
public interface IIndexService {

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup index
	 * @api {GET} /index/{category}/getIndexList/{position}/{pageSize} 房间列表
	 * @apiName getIndexList
	 *
	 *
	 * @apiDescription
     * >  房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏 </br>
	 * > 【最热=1】：砖石数排序（大-小）,主播昵称、直播标题、房间类型（若普通房间收费模式不现实）、房间人数（真实人数和机器人数）、网络状态（API不提供）</br>
	 * > 【最新=3】：主播开播时间（近-远）排序，主播昵称、房间类型、房间人数（真实人数和机器人数）、网络状态（API不提供）</br>
	 * > 【收藏=2】：显示关注后的主播房间,顺序直播类型-录播类型</br>
	 *   > (1)直播类型=砖石数排序（大-小）,直播状态、房间人数、主播昵称、开播信息、网络状态、收费模式（普通房间不显示）</br>
	 *   > (2)录播类型=发布日期（近-远），被观看次数、收费价格（普通房间不显示）、主播昵称、开播信息</br>
	 * > 【付费=4】：砖石数排序（大-小）,开播标题、房间类型、房间人数（真实人数和机器人数）、网络状态（API不提供）</br>
	 * > 【游戏=5】：房间游戏投注数排序（大-小）,主播昵称、开播标题、游戏类型、参与人数（如上第二条解释）、网络状态（API不提供）</br>
	 *
	 * @apiSuccess {Integer} total 		总数
	 * @apiSuccess {Integer} rows 		rows->row
	 * @apiSuccess {Integer} row.roomId 		房间ID
	 * @apiSuccess {Integer} row.zbId 		主播ID
	 * @apiSuccess {Integer} row.roomPlanId 		房间场次ID
	 * @apiSuccess {String} row.zbNickName 	主播昵称
	 * @apiSuccess {String} row.zbHeadImg 	主播头像
	 * @apiSuccess {String} row.zbLevel 	主播等级
	 * @apiSuccess {String} row.roomTitle  	房间标题
	 * @apiSuccess {String} row.roomType   	房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','personal=私密房间','game=游戏房间'
	 * @apiSuccess {Integer} row.onlineUser  真实在线用户
	 * @apiSuccess {Integer} row.machineUser 机器用户
	 * @apiSuccess {Integer} row.viewCount 	总浏览次数
	 * @apiSuccess {Integer} row.watchCount 	总观看次数
	 * @apiSuccess {String} row.roomBackgroundImg  房间背景图片
	 * @apiSuccess {Integer} row.roomStatus  	直播状态： 1=直播中，2=未开播，3=回放中
	 * @apiSuccess {Timestamp} row.startTime  	房间开播时间
	 * @apiSuccess {String} [row.gameIcon]  	游戏图标
	 * @apiSuccess {String} row.playUrl 	录像回放地址
	 * @apiSuccess {Integer} row.isCharge 	是否收费   0=不收费，1=收费
	 */
	public PageModel<IndexResponseVo> getIndexList(Integer userId,String category, Integer position, Integer pageSize) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup index
	 * @api {GET} /index/{category}/getBannerList 直播首页Banner列表
	 * @apiName getBannerList
	 *
	 *
	 * @apiDescription
	 * > 需要显示Banner的模块：最新、最热</br>
     * >category 房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏</br>
	 *
	 *
	 * @apiSuccess {Integer} id 	BannerID
	 * @apiSuccess {String} title 	Banner标题
	 * @apiSuccess {String} thumb_img_url 	Banner图片地址
	 * @apiSuccess {String} url 	跳转地址
	 * @apiSuccess {String} type  Banner类型（1=最新、3=最热）
	 *
	 */
	public List<BannerResponseVo> getBannerList(String category) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup index
	 * @api {GET} /index/{category}/getMsgNotificationList 公告消息列表
	 * @apiName getMsgNotificationList
	 *
	 *
	 * @apiDescription
	 * > 需要显示MsgNotification的模块：最新、最热</br>
     * >category 房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏</br>
	 *
	 *
	 * @apiSuccess {Integer} id 		公告消息ID
	 * @apiSuccess {String} title 	公告消息内容
	 * @apiSuccess {String} url 	点击事件
	 *
	 */
	public List<MsgNotificationResponseVo> getMsgNotification(String category) throws ServiceException;
}

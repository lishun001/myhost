package com.eason.api.zb.service.impl;

import com.eason.api.zb.IIndexService;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.dao.*;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.PageModel;
import com.eason.api.zb.model.ZbConstant;
import com.eason.api.zb.po.*;
import com.eason.api.zb.vo.index.BannerResponseVo;
import com.eason.api.zb.vo.index.IndexResponseVo;
import com.eason.api.zb.vo.index.MsgNotificationResponseVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexServiceImpl implements IIndexService {
    private static Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private IndexBannerDao indexBannerDao;
    @Autowired
    private MsgNotificationDao msgNotificationDao;
    @Autowired
    private RoomPlanDao roomPlanDao;
    @Autowired
    private RoomPlanStatDao roomPlanStatDao;
    @Autowired
    private UcUserDao ucUserDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private UserAttentionDao userAttentionDao;
    @Autowired
    private RoomRecrecordDao roomRecrecordDao;

    @RequestMapping(value = "/{category}/getIndexList/{position}/{pageSize}",method = RequestMethod.GET)
    @Override
    public PageModel<IndexResponseVo> getIndexList(Integer userId, @PathVariable(value = "category") String category,@PathVariable(value = "position") Integer position,@PathVariable(value = "pageSize")  Integer pageSize)  throws ServiceException{
        try {
            PageModel pageModel=new PageModel();
            List<IndexResponseVo> list = new ArrayList<>();
            List<ZbTRecrecordsLog> logList=new ArrayList<>();
            Page<ZbTRoomPlan> page=null;
            if("1".equals(category)){ //最热=1
                Pageable pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "incomeAmount");
                page=roomPlanDao.findAll(pageable);
            }else if ("2".equals(category)){ //收藏=2
                //TODO 录播类型=发布日期（近-远）
                List<ZbTUserAttention> attentionList=userAttentionDao.findAllByAId(userId); //查询useId所关注的用户+主播
                List<Integer> ids=new ArrayList<>();
                attentionList.forEach(ZbTUserAttention->{
                    ids.add(ZbTUserAttention.getfId());
                });
                PageRequest pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "incomeAmount");
                page=  roomPlanDao.findByUserIds(ids,pageable);
                //直播间已经显示完全,新增回放
                if (!page.hasNext()){
                    if (!ids.isEmpty() && page.getNumberOfElements()!=0){
                        logList= roomRecrecordDao.findAllByZbIds(ids); //TODO ids是用户id
                    }
                }
            }else if ("3".equals(category)){ //最新=3
                Pageable pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "openTime");
                page=  roomPlanDao.findAll(pageable);
            }else if ("4".equals(category)){ //付费=4
                Pageable pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "incomeAmount");
                List<String> roomTypes=new ArrayList<>();
                roomTypes.add(ZbConstant.Room.Type.ticket.name());
                roomTypes.add(ZbConstant.Room.Type.time.name());
                roomTypes.add(ZbConstant.Room.Type.personal.name());
                page= roomPlanDao.findByChargedRoom(roomTypes,pageable);
            }else if ("5".equals(category)){ //游戏
                Pageable pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "incomeAmount");
                page=  roomPlanDao.findByRoomType(ZbConstant.Room.Type.game.name(),pageable);
            }else{
               throw new ServiceException("首页列表只支持category=1，2，3，4，5类型");
            }
            pageModel.setTotal(page.getTotalPages());
            page.getContent().forEach(zbTRoomPlan ->{
                //需要Qvod系统拿主播昵称
                ZbUcUser zbUcUser=this.ucUserDao.findByZbId(zbTRoomPlan.getZbId());
                String nickName=zbUcUser.getNickname();
                String avatar=zbUcUser.getAvatar();
                Integer level=zbUcUser.getLevel()*1;

                IndexResponseVo indexResponseVo=new IndexResponseVo(zbTRoomPlan.getRoomId(),zbTRoomPlan.getZbId(),nickName,zbTRoomPlan.getRoomTitle(),
                        zbTRoomPlan.getRoomType(),zbTRoomPlan.getOnlineUser(),zbTRoomPlan.getMachineUser(),zbTRoomPlan.getRoomBgPic(),
                        zbTRoomPlan.getRoomStatus(),new Timestamp(zbTRoomPlan.getOpenTime().getTime()));
                indexResponseVo.setRoomPlanId(zbTRoomPlan.getPlanId());
                indexResponseVo.setZbHeadImg(avatar);
                indexResponseVo.setZbLevel(level);//需要Qvod系统拿用户等级

                indexResponseVo.setIsCharge(0);  //0=不收费
                //新增收费房间是否收费字段
                Map<String,Object> map=zbTRoomPlan.getRoomSet();
                if (map!=null && !map.isEmpty()){
                    Date startTime=(Date) map.get("startTime");
                    Date overTime=(Date) map.get("overTime");
                    Date now=new Date();
                    if (now.compareTo(startTime)>=0 && now.compareTo(overTime)<=0){
                        indexResponseVo.setIsCharge(1);  //1=收费
                    }
                }

                list.add(indexResponseVo);
            });
            if ("2".equals(category) && !logList.isEmpty()){
                logList.forEach(zbTRecrecordsLog -> {
                    //TODO 录播视频数据待完善
                    ZbTRoomPlanStat zbTRoomPlanStat=this.roomPlanStatDao.findByPlanId(zbTRecrecordsLog.getPlanId());
                    ZbTRoom zbTRoom=this.roomDao.findByZbId(zbTRoomPlanStat.getZbId());
                    ZbUcUser zbUcUser=this.ucUserDao.findByZbId(zbTRoomPlanStat.getZbId());
                    IndexResponseVo indexResponseVo=new IndexResponseVo(zbTRoomPlanStat.getRoomId(),zbTRoomPlanStat.getZbId(),zbUcUser.getNickname(),zbTRoomPlanStat.getRoomTitle(),
                            zbTRoomPlanStat.getRoomType(),0,0,zbTRoom.getRoomBgPic(),
                            ZbConstant.Room.status.room_redio,new Timestamp(zbTRoomPlanStat.getOpenTime().getTime()));
                    indexResponseVo.setRoomPlanId(zbTRoomPlanStat.getPlanId());
                    indexResponseVo.setZbHeadImg(zbUcUser.getAvatar());
                    indexResponseVo.setZbLevel(zbUcUser.getLevel()*1);//需要Qvod系统拿用户等级
                    indexResponseVo.setRoomStatus(ZbConstant.Room.status.room_redio); //回放中的状态
                    indexResponseVo.setPlayUrl(zbTRecrecordsLog.getPlayUrl());
                    indexResponseVo.setIsCharge(0);  //0=不收费
                    list.add(indexResponseVo);
                });
                //TODO 视频回放分页待确定
                pageModel.setTotal(1);
            }
            pageModel.setRows(list);
            return pageModel;
        } catch (Exception e) {
            logger.error("index",e.getMessage());
            throw new ServiceException(e);
        }
    }

    @RequestMapping(value = "/{category}/getBannerList",method = RequestMethod.GET)
    @Override
    public List<BannerResponseVo> getBannerList( @PathVariable(value = "category") String category)  throws ServiceException{
        try {
            List<BannerResponseVo> list = new ArrayList<BannerResponseVo>();
            List<ZbTIndexBanner> bannerList=indexBannerDao.findAll();
            bannerList.forEach(indexBanner->{
                list.add(new BannerResponseVo(indexBanner.getId(), indexBanner.getTitle(), indexBanner.getThumbImgUrl(), indexBanner.getType(), indexBanner.getUrl()));
            });
            return list;
        } catch (Exception e) {
            logger.error("index",e.getMessage());
            throw new ServiceException(e);
        }
    }

    @RequestMapping(value = "/{category}/getMsgNotificationList",method = RequestMethod.GET)
    @Override
    public List<MsgNotificationResponseVo> getMsgNotification( @PathVariable(value = "category") String category) throws ServiceException{
        try {
            List<MsgNotificationResponseVo> list = new ArrayList<MsgNotificationResponseVo>();
            List<ZbTMsgNotification> msgNotificationList=msgNotificationDao.findAll();
            msgNotificationList.forEach(zbTMsgNotification -> {
                list.add(new MsgNotificationResponseVo(zbTMsgNotification.getId(),zbTMsgNotification.getTitle(),zbTMsgNotification.getUrl()));
            });
            return list;
        } catch (Exception e) {
            logger.error("index",e.getMessage());
            throw new ServiceException(e);
        }
    }
}

package com.eason.api.zb.service.impl;

import com.eason.api.zb.IIndexService;
import com.eason.api.zb.cache.ZbTRoomPlan;
import com.eason.api.zb.dao.*;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.PageModel;
import com.eason.api.zb.model.ZbConstant;
import com.eason.api.zb.po.ZbTIndexBanner;
import com.eason.api.zb.po.ZbTMsgNotification;
import com.eason.api.zb.po.ZbTUserAttention;
import com.eason.api.zb.vo.index.BannerResponseVo;
import com.eason.api.zb.vo.index.IndexResponseVo;
import com.eason.api.zb.vo.index.MsgNotificationResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    private UserAttentionDao userAttentionDao;

    @RequestMapping(value = "/{category}/getIndexList/{position}/{pageSize}",method = RequestMethod.GET)
    @Override
    public PageModel<IndexResponseVo> getIndexList(Integer userId, @PathVariable(value = "category") String category,@PathVariable(value = "position") Integer position,@PathVariable(value = "pageSize")  Integer pageSize)  throws ServiceException{
        try {
            PageModel pageModel=new PageModel();
            List<IndexResponseVo> list = new ArrayList<>();
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
                Pageable pageable = new PageRequest(position, pageSize, Sort.Direction.DESC, "incomeAmount");
                page=  roomPlanDao.findByZbIds(ids,pageable);

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
                String nickName=zbTRoomPlan.getZbNickname();
                String avatar=zbTRoomPlan.getZbHeadImg();
                Integer level=zbTRoomPlan.getZbLevel();

                IndexResponseVo indexResponseVo=new IndexResponseVo(zbTRoomPlan.getRoomId(),zbTRoomPlan.getZbId(),nickName,zbTRoomPlan.getRoomTitle(),
                        zbTRoomPlan.getRoomType(),zbTRoomPlan.getOnlineUser(),zbTRoomPlan.getMachineUser(),zbTRoomPlan.getRoomBgPic(),
                        zbTRoomPlan.getRoomStatus(),new Timestamp(zbTRoomPlan.getOpenTime().getTime()));
                indexResponseVo.setRoomPlanId(zbTRoomPlan.getPlanId());
                indexResponseVo.setZbHeadImg(avatar);
                indexResponseVo.setZbLevel(level);//需要Qvod系统拿用户等级
                list.add(indexResponseVo);
            });

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

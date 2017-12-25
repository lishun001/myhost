package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.FileItemModel;
import com.eason.api.zb.service.FRoomService;
import com.eason.api.zb.service.FUserService;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import org.springframework.stereotype.Component;

@Component("roomServiceImpl")
public class FRoomServiceImpl implements FRoomService {
    @Override
    public RoomResponseVo enterRoom(Integer userId, Integer roomId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public RoomStatResponseVo backRoom(Integer userId, Integer roomId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public IsChargedResponseVo isCharged(Integer userId, Integer roomId) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public RoomSetResponseVo getRoomSet(String roomType) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String setRoomBackgroundImg(Integer userId, Integer roomId, FileItemModel fileImg) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public String getRoomWaterMarkImg(Integer userId) throws ServiceException {
       throw new ServiceException();
    }
}

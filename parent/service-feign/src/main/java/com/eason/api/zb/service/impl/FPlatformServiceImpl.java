package com.eason.api.zb.service.impl;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.FileItemModel;
import com.eason.api.zb.service.FPlatformService;
import com.eason.api.zb.service.FRoomService;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;
import org.springframework.stereotype.Component;

@Component("platformServiceImpl")
public class FPlatformServiceImpl implements FPlatformService {
    @Override
    public MediaResponseVo getMedia(Integer zbId, String token) throws ServiceException {
       throw new ServiceException();
    }

    @Override
    public IMResponseVo getIM(Integer zbId, String token) throws ServiceException {
       throw new ServiceException();
    }
}

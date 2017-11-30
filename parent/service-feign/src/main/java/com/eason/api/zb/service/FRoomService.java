package com.eason.api.zb.service;

import com.eason.api.zb.IRoomService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.FileItemModel;
import com.eason.api.zb.service.impl.FRoomServiceImpl;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-api-zb-impl", fallback = FRoomServiceImpl.class)
public interface FRoomService extends IRoomService {
    @RequestMapping(value = "/room/{roomId}/enterRoom", method = RequestMethod.GET)
    RoomResponseVo enterRoom(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException;

    @RequestMapping(value = "/room/{roomId}/backRoom/{userId}", method = RequestMethod.GET)
    RoomStatResponseVo backRoom(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException;

    @RequestMapping(value = "/room/{roomId}/isCharged", method = RequestMethod.GET)
    IsChargedResponseVo isCharged(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "roomId") Integer roomId) throws ServiceException;

    @RequestMapping(value = "/room/{roomType}/getRoomSet", method = RequestMethod.GET)
    RoomSetResponseVo getRoomSet(@PathVariable(value = "roomType") String roomType) throws ServiceException;

    @RequestMapping(value = "/room/{roomId}/setRoomBackgroundImg", method = RequestMethod.POST)
    String setRoomBackgroundImg(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "roomId") Integer roomId, @RequestBody FileItemModel fileImg) throws ServiceException;

    @RequestMapping(value = "/room/getRoomWaterMarkImg", method = RequestMethod.GET)
    String getRoomWaterMarkImg(@RequestParam(value = "userId") Integer userId) throws ServiceException;
}

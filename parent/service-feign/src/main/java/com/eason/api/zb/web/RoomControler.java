package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.IRoomService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.FileItemModel;
import com.eason.api.zb.service.FRoomService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/room")
public class RoomControler {
    @Autowired
    private FRoomService roomServiceImpl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/{roomId}/isCharged", method = RequestMethod.GET)
    public ResponseVo isCharged(@PathVariable Integer roomId, HttpServletRequest request) {
        try {
            Integer userId = null;
            String api_token = request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)) {
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)) {
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id == null) {
                    throw new ServiceException("token=" + api_token + " is error");
                } else {
                    userId = Integer.parseInt(id);
                }
            } else {
                throw new ServiceException("token is empty");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(roomServiceImpl.isCharged(userId, roomId));
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/{roomType}/getRoomSet", method = RequestMethod.GET)
    public ResponseVo getRoomSet(@PathVariable String roomType) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(roomServiceImpl.getRoomSet(roomType));
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/{roomId}/setRoomBackgroundImg", method = RequestMethod.POST)
    public ResponseVo setRoomBackgroundImg(HttpServletRequest request,@PathVariable Integer roomId, @RequestParam(value = "roomBackgroundImg", required = true) MultipartFile img) {
        ResponseVo responseVo = null;
        try {
            Integer userId=null;
            String api_token=request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)){
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)){
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id == null) {
                    throw new ServiceException("token="+api_token+" is error");
                }else{
                    userId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("token is empty");
            }
            responseVo = new ResponseVo(0, "操作成功");
            FileItemModel fileImg = new FileItemModel();
            fileImg.setFileName(System.currentTimeMillis() + "-" + img.getOriginalFilename());
            fileImg.setContent(img.getBytes());
            fileImg.setMimeType(img.getContentType());
            responseVo.setData(roomServiceImpl.setRoomBackgroundImg(userId,roomId, fileImg));
        } catch (Exception e) {
            responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
        }
        return responseVo;
    }

    @RequestMapping(value = "/{roomId}/enterRoom", method = RequestMethod.GET)
    public ResponseVo enterRoom(HttpServletRequest request, @PathVariable Integer roomId) {
        try {
            Integer userId = null;
            String api_token = request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)) {
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)) {
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id == null) {
                    throw new ServiceException("token=" + api_token + " is error");
                } else {
                    userId = Integer.parseInt(id);
                }
            } else {
                throw new ServiceException("token is empty");
            }

            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(roomServiceImpl.enterRoom(userId, roomId));
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/{roomId}/backRoom/{userId}", method = RequestMethod.GET)
    public ResponseVo backRoom(@PathVariable Integer userId, @PathVariable Integer roomId) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(roomServiceImpl.backRoom(userId, roomId));
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/getRoomWaterMarkImg", method = RequestMethod.GET)
    public ResponseVo getRoomWaterMarkImg(HttpServletRequest request) {
        try {
            Integer userId = null;
            String api_token = request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)) {
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)) {
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id == null) {
                    throw new ServiceException("token=" + api_token + " is error");
                } else {
                    userId = Integer.parseInt(id);
                }
            } else {
                throw new ServiceException("token is empty");
            }

            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(roomServiceImpl.getRoomWaterMarkImg(userId));
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

}

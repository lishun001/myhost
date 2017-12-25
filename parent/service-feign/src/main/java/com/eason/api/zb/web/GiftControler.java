package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FGiftService;
import com.eason.api.zb.vo.gift.SendBombScreenRequestVo;
import com.eason.api.zb.vo.gift.SendGiftRequestVo;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/gift")
public class GiftControler {

    @Autowired
    private FGiftService giftServiceImpl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseVo getList(HttpServletRequest request) {
        try {
            Integer userId=null;
            String api_token=request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)){
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)){
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id != null) {
                    userId=Integer.parseInt(id);
                }
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(giftServiceImpl.getList(userId));
            return responseVo;
        } catch (ServiceException e) {
            ResponseVo responseVo = new ResponseVo(401, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/sendGift/{zbId}", method = RequestMethod.POST)
    public ResponseVo sendGift(Integer userId, @PathVariable Integer zbId, @RequestBody SendGiftRequestVo sendGiftRequestVo) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(giftServiceImpl.sendGift(userId, zbId, sendGiftRequestVo));
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/sendBombScreen/{zbId}", method = RequestMethod.POST)
    public ResponseVo sendBombScreen(Integer userId, @PathVariable Integer zbId, @RequestBody SendBombScreenRequestVo sendBombScreenRequestVo) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(giftServiceImpl.sendBombScreen(userId, zbId, sendBombScreenRequestVo));
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }
}

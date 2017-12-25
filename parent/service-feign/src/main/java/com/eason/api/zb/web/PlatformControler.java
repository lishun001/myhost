package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.IPlatformService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FPlatformService;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/platform")
public class PlatformControler {
    @Autowired
    private FPlatformService platformServiceImpl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/im/get/{zbId}", method = RequestMethod.GET)
    public ResponseVo getIm(HttpServletRequest request, @PathVariable Integer zbId) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                } else {
                    userId = Integer.parseInt(id);
                }
            } else {
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(platformServiceImpl.getIM(zbId, api_token));
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

    @RequestMapping(value = "/media/get/{zbId}", method = RequestMethod.GET)
    public ResponseVo getMedia(HttpServletRequest request, @PathVariable Integer zbId) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                } else {
                    userId = Integer.parseInt(id);
                }
            } else {
                throw new ServiceException("您未登陆");
            }

            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(platformServiceImpl.getMedia(zbId, api_token));
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

}

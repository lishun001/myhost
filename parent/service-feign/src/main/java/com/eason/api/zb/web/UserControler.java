package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserControler {
    @Autowired
    private FUserService userServiceImpl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/isTrySee/{roomId}/{isTrySee}", method = RequestMethod.GET)
    public ResponseVo isTrySee(HttpServletRequest request, @PathVariable Integer roomId, @PathVariable Boolean isTrySee) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                }else{
                    userId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(userServiceImpl.isTrySee(userId, roomId, isTrySee));
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

    @RequestMapping(value = "/{channel}/isAttention/{userIds}/{isAttention}", method = RequestMethod.GET)
    public ResponseVo isAttention(HttpServletRequest request, @PathVariable Integer channel, @PathVariable String userIds, @PathVariable Boolean isAttention) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                }else{
                    userId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(userServiceImpl.isAttention(userId, channel, userIds, isAttention));
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

    @RequestMapping(value = "/getDetail/{userId}", method = RequestMethod.GET)
    public ResponseVo getDetail(HttpServletRequest request, @PathVariable(value = "userId") Integer userId) {
        try {
            Integer tokenUserId=null;
            String api_token=request.getHeader("api_token");
            if (StringUtils.isEmpty(api_token)){
                api_token = request.getParameter("token");
            }
            if (StringUtils.isNotEmpty(api_token)){
                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
                String id = ops.get(api_token);
                if (id == null) {
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                }else{
                    tokenUserId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(userServiceImpl.getDetail(tokenUserId,userId));
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

    @RequestMapping(value = "/isBook/{zbId}/{isBook}", method = RequestMethod.GET)
    public ResponseVo isBook(HttpServletRequest request,  @PathVariable Integer zbId, @PathVariable Boolean isBook) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                }else{
                    userId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(userServiceImpl.isBook(userId, zbId, isBook));
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

    @RequestMapping(value = "/{channel}/isBlack/{userIds}/{isBlack}", method = RequestMethod.GET)
    public ResponseVo isBlack(HttpServletRequest request, @PathVariable Integer channel, @PathVariable String userIds, @PathVariable Boolean isBlack) {
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
                    throw new ServiceException("您的账号已在异地登陆，请您重新登陆");
                }else{
                    userId=Integer.parseInt(id);
                }
            }else{
                throw new ServiceException("您未登陆");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(userServiceImpl.isBlack(userId, channel,userIds, isBlack));
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

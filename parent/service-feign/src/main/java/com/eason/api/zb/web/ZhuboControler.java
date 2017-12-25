package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.IZhuboService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FZhuboService;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/zhubo")
public class ZhuboControler {
    private static Logger log = LoggerFactory.getLogger(ZhuboControler.class);

    @Autowired
    private FZhuboService zhuboServiceImpl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public ResponseVo apply(HttpServletRequest request) {
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
            responseVo.setData(zhuboServiceImpl.apply(userId));
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

    @RequestMapping(value = "/getZhuboList/{num}", method = RequestMethod.GET)
    public ResponseVo getZhuboList(HttpServletRequest request,@PathVariable Integer num) {
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
            responseVo.setData(zhuboServiceImpl.getZhuboList(userId,num));
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new ArrayList<>());
            return responseVo;
        }
    }


    @RequestMapping(value = "/{zbId}/getGiftUserList/{category}", method = RequestMethod.GET)
    public ResponseVo getGiftUserList(@PathVariable Integer zbId, @PathVariable String category) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(zhuboServiceImpl.getGiftUserList(zbId, category));
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new ArrayList<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/{zbId}/getAttentionUserList", method = RequestMethod.GET)
    public ResponseVo getAttentionUserList(@PathVariable Integer zbId) {
        try {
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(zhuboServiceImpl.getAttentionUserList(zbId));
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new ArrayList<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/getZbDetail/{zbId}", method = RequestMethod.GET)
    public ResponseVo getZbDetail(HttpServletRequest request, @PathVariable Integer zbId) {
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
            responseVo.setData(zhuboServiceImpl.getZbDetail(userId, zbId));
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

    @RequestMapping(value = "/startPlay", method = RequestMethod.POST)
    public ResponseVo startPlay(HttpServletRequest request,  @RequestBody  StartPlayRequestVo startPlayRequestVo) {
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
            responseVo.setData(zhuboServiceImpl.startPlay(userId, startPlayRequestVo));
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

    @RequestMapping(value = "/overPlay/{planId}", method = RequestMethod.GET)
    public ResponseVo overPlay(HttpServletRequest request,@PathVariable Integer planId) {
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
            responseVo.setData(zhuboServiceImpl.overPlay(userId,planId));
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

    @RequestMapping(value = "/saveVideo/{planId}", method = RequestMethod.GET)
    public ResponseVo saveVideo(HttpServletRequest request,@PathVariable Integer planId) {
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
            responseVo.setData(zhuboServiceImpl.saveVideo(userId,planId));
            return responseVo;
        } catch (ServiceException e) {
            ResponseVo responseVo = new ResponseVo(401, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        }catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/getReadyPlayInfo", method = RequestMethod.GET)
    public ResponseVo getReadyPlayInfo(HttpServletRequest request) {
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
            responseVo.setData(zhuboServiceImpl.getReadyPlayInfo(userId,api_token));
            return responseVo;
        } catch (ServiceException e) {
            ResponseVo responseVo = new ResponseVo(401, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        } catch (HystrixRuntimeException e) {
            ResponseVo responseVo = new ResponseVo(500, "服务器忙，请重试！");
            responseVo.setData(new HashMap<>());
            return responseVo;
        }catch (Exception e) {
            ResponseVo responseVo = new ResponseVo(500, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }
    }

    @RequestMapping(value = "/getStat/{planId}", method = RequestMethod.GET)
    public ResponseVo getStat(HttpServletRequest request, @PathVariable Integer planId) {
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
            responseVo.setData(zhuboServiceImpl.getStat(userId, planId));
            return responseVo;
        } catch (ServiceException e) {
            ResponseVo responseVo = new ResponseVo(401, e.getMessage());
            responseVo.setData(new HashMap<>());
            return responseVo;
        }  catch (HystrixRuntimeException e) {
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

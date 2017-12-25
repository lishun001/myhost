package com.eason.api.zb.web;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.service.FPlatformService;
import com.eason.api.zb.service.FTaskService;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/task")
public class TaskControler {
    @Autowired
    private FTaskService taskServiceImpl;

    @Value("${user.author.token}")
    private String author;

    @RequestMapping(value = "/resetTrySee", method = RequestMethod.GET)
    public ResponseVo resetTrySee(HttpServletRequest request) {
        try {
            String token = request.getParameter("token");
            if (!author.equals(token)){
                throw new ServiceException("token="+token+" is error");
            }
            ResponseVo responseVo = new ResponseVo(0, "操作成功");
            responseVo.setData(taskServiceImpl.resetTrySee());
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

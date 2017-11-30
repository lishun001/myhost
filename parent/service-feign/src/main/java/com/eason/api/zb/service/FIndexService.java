package com.eason.api.zb.service;

import com.eason.api.zb.IIndexService;
import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.model.PageModel;
import com.eason.api.zb.service.impl.FIndexServiceImpl;
import com.eason.api.zb.vo.index.BannerResponseVo;
import com.eason.api.zb.vo.index.IndexResponseVo;
import com.eason.api.zb.vo.index.MsgNotificationResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-api-zb-impl",fallback = FIndexServiceImpl.class )
public interface FIndexService extends IIndexService {
    @RequestMapping(value = "/index/{category}/getIndexList/{position}/{pageSize}",method = RequestMethod.GET)
    PageModel<IndexResponseVo> getIndexList(@RequestParam(value = "userId") Integer userId, @PathVariable(value = "category") String category, @PathVariable(value = "position") Integer position, @PathVariable(value = "pageSize") Integer pageSize) throws ServiceException;

    @RequestMapping(value = "/index/{category}/getBannerList",method = RequestMethod.GET)
    List<BannerResponseVo> getBannerList(@PathVariable(value = "category") String category) throws ServiceException;

    @RequestMapping(value = "/index/{category}/getMsgNotificationList",method = RequestMethod.GET)
    List<MsgNotificationResponseVo> getMsgNotification(@PathVariable(value = "category") String category) throws ServiceException;
}

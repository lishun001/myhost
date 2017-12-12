package com.eason.api.zb.controler;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexControler  {
    @Autowired
    private IIndexService indexServiceImpl;

    @RequestMapping(value = "/{category}/getIndexList/{position}/{pageSize}",method = RequestMethod.GET)
    public ResponseVo getIndexList(@PathVariable String category,@PathVariable Integer position,@PathVariable Integer pageSize) {
        ResponseVo responseVo=new ResponseVo(0,"操作成功");
        responseVo.setData(indexServiceImpl.getIndexList(category,position,pageSize));
        return responseVo;
    }

    @RequestMapping(value = "/{category}/getMsgNotificationList",method = RequestMethod.GET)
    public ResponseVo getMsgNotificationList(@PathVariable String category) {
        ResponseVo responseVo=new ResponseVo(0,"操作成功");
        responseVo.setData(indexServiceImpl.getMsgNotification(category));
        return responseVo;
    }

    @RequestMapping(value = "/{category}/getBannerList",method = RequestMethod.GET)
    public ResponseVo getBannerList(@PathVariable String category) {
        ResponseVo responseVo=new ResponseVo(0,"操作成功");
        responseVo.setData(indexServiceImpl.getBannerList(category));
        return responseVo;
    }
}

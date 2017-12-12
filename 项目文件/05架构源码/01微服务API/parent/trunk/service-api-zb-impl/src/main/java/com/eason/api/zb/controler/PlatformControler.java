package com.eason.api.zb.controler;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.service.IPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformControler {
    @Autowired
    private IPlatformService platformServiceImpl;

    @RequestMapping(value = "/im/get",method = RequestMethod.GET)
    public ResponseVo getIm() {
        ResponseVo responseVo=new ResponseVo(0,"操作成功");
        responseVo.setData(platformServiceImpl.getIM());
        return responseVo;
    }

    @RequestMapping(value = "/media/get",method = RequestMethod.GET)
    public ResponseVo getMedia() {
        ResponseVo responseVo=new ResponseVo(0,"操作成功");
        responseVo.setData(platformServiceImpl.getMedia());
        return responseVo;
    }

}

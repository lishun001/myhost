package com.eason.api.zb.controler;

import com.eason.api.base.vo.response.ResponseVo;
import com.eason.api.zb.service.IGiftService;
import com.eason.api.zb.vo.gift.SendBombScreenRequestVo;
import com.eason.api.zb.vo.gift.SendGiftRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gift")
public class GiftControler {

    @Autowired
    private IGiftService giftServiceImpl;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public ResponseVo getList() {
        ResponseVo responseVo = new ResponseVo(0, "操作成功");
        responseVo.setData(giftServiceImpl.getList());
        return responseVo;
    }

    @RequestMapping(value = "/{userId}/sendGift/{zbId}", method = RequestMethod.GET)
    public ResponseVo sendGift(@PathVariable Integer userId, @PathVariable Integer zbId, SendGiftRequestVo sendGiftRequestVo) {
        ResponseVo responseVo = new ResponseVo(0, "操作成功");
        System.out.println("-----SendGiftResponseVo-----userId=" + userId + "---zbId" + zbId);
        responseVo.setData(giftServiceImpl.sendGift(userId, zbId, sendGiftRequestVo));
        return responseVo;
    }

    @RequestMapping(value = "/{userId}/sendBombScreen/{zbId}", method = RequestMethod.GET)
    public ResponseVo sendBombScreen(@PathVariable Integer userId, @PathVariable Integer zbId, SendBombScreenRequestVo sendBombScreenRequestVo) {
        ResponseVo responseVo = new ResponseVo(0, "操作成功");
        System.out.println("-----SendGiftResponseVo-----userId=" + userId + "---zbId" + zbId);
        responseVo.setData(giftServiceImpl.sendBombScreen(userId, zbId, sendBombScreenRequestVo));
        return responseVo;
    }
}

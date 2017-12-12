package com.eason.api.zb.service.impl;

import com.eason.api.zb.service.IPlatformService;
import com.eason.api.zb.vo.platform.IMResponseVo;
import com.eason.api.zb.vo.platform.MediaResponseVo;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl implements IPlatformService {
    @Override
    public MediaResponseVo getMedia() {
        return new MediaResponseVo(1, "http://media", "access_token");
    }

    @Override
    public IMResponseVo getIM() {
        return new IMResponseVo(1, "http://im", "8080", "access_token");
    }
}

package com.eason.api.zb.service.impl;

import com.eason.api.zb.service.IIndexService;
import com.eason.api.zb.vo.index.BannerResponseVo;
import com.eason.api.zb.vo.index.IndexResponseVo;
import com.eason.api.zb.vo.index.MsgNotificationResponseVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl implements IIndexService {
    @Override
    public List<IndexResponseVo> getIndexList(String category, Integer position, Integer pageSize) {
        List<IndexResponseVo> list = new ArrayList<IndexResponseVo>();

        IndexResponseVo indexResponseVo1 = new IndexResponseVo(1,1,"卤蛋N01", "卤蛋01的直播间",
                "ticket", 80,6000, "http://bgImg01", 1, new Timestamp(System.currentTimeMillis()), "http://gameIcon");
        IndexResponseVo indexResponseVo2 = new IndexResponseVo(2, 2, "卤蛋N02", "卤蛋02的直播间",
                "time", 6000,100, "http://bgImg02", 1, new Timestamp(System.currentTimeMillis()), "http://gameIcon");
        IndexResponseVo indexResponseVo3 = new IndexResponseVo(3, 3, "卤蛋N03", "卤蛋03的直播间",
                "personal",6000, 200, "http://bgImg03", 1, new Timestamp(System.currentTimeMillis()), "http://gameIcon");
        list.add(indexResponseVo1);
        list.add(indexResponseVo2);
        list.add(indexResponseVo3);
        return list;
    }

    @Override
    public List<BannerResponseVo> getBannerList(String category) {
        List<BannerResponseVo> list = new ArrayList<BannerResponseVo>();
        list.add(new BannerResponseVo(1, "Banner01", "http://bannerImg01", "1", "http://eventUrl001"));
        list.add(new BannerResponseVo(2,"Banner02", "http://bannerImg02", "1", "http://eventUrl001"));
        list.add(new BannerResponseVo(3, "Banner03", "http://bannerImg03", "1", "http://eventUrl001"));
        return list;
    }

    @Override
    public List<MsgNotificationResponseVo> getMsgNotification(String category) {
        List<MsgNotificationResponseVo> list = new ArrayList<MsgNotificationResponseVo>();
        list.add(new MsgNotificationResponseVo(1, "好消息中奖啦01", "http://eventUrl001"));
        list.add(new MsgNotificationResponseVo(2, "好消息中奖啦02", "http://eventUrl002"));
        list.add(new MsgNotificationResponseVo(3, "好消息中奖啦03", "http://eventUrl003"));
        return list;
    }
}

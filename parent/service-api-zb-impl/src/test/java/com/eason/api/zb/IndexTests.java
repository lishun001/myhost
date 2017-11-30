package com.eason.api.zb;

import com.eason.api.zb.model.SaveMongoEventListener;
import com.eason.api.zb.dao.IndexBannerDao;
import com.eason.api.zb.dao.MsgNotificationDao;
import com.eason.api.zb.dao.UserPersonalDao;
import com.eason.api.zb.model.ZbConstant;
import com.eason.api.zb.po.ZbTIndexBanner;
import com.eason.api.zb.po.ZbTMsgNotification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexTests {
	@Autowired
	private IndexBannerDao indexBannerDao;
	@Autowired
	private MsgNotificationDao msgNotificationDao;
	@Autowired
	private UserPersonalDao userPersonalDao;
	@Autowired
	private SaveMongoEventListener saveMongoEventListener;

	@Test
	public void addIndexBanner() {
		ZbTIndexBanner indexBanner=new ZbTIndexBanner();
		indexBanner.setTitle("标题测试003");
		indexBanner.setUrl("http://indexBanner-url.png");
		indexBanner.setType(ZbConstant.Room.Type.ticket.name());
		indexBanner.setThumbImgUrl("http://indexBanner-iimg-url.png");
		indexBanner.setCreateUser("admin");
		indexBanner.setCreateTime(new Timestamp(System.currentTimeMillis()));
		indexBannerDao.save(indexBanner);
	}

	@Test
	public void addMsgNotification() {
		ZbTMsgNotification msgNotification=new ZbTMsgNotification();
		msgNotification.setTitle("消息003");
		msgNotification.setUrl("http://msgNotification-url.png");
		msgNotification.setType(ZbConstant.Room.Type.ticket.name());
		msgNotification.setCreateUser("admin");
		msgNotification.setCreateTime(new Timestamp(System.currentTimeMillis()));
		msgNotificationDao.save(msgNotification);
	}
}

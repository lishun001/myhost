//package com.openoo.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import model.push.PushTemplatePo;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.jiuwu.openoo.service.common.VelocityService;
//import com.jiuwu.openoo.service.push.IPushService;
//
///**
// * 消息推送
// * @author eason
// *
// */
//public class PushTest {
//	private ClassPathXmlApplicationContext ac;
//	private VelocityService velocityService;
//	private IPushService pushServiceImpl;
//	@Before
//	public void setUp() throws Exception {
//		ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
//		velocityService = (VelocityService)ac.getBean("velocityService");
//		pushServiceImpl = (IPushService)ac.getBean("pushServiceImpl");
//	}
//
//	@Test
//	public void test1() {
//		try{
//			Map<String, Object> model=new HashMap<String,Object>();
//			model.put("code", "CANCEL");
//			model.put("taskName", "带饭呀呀呀");
//			model.put("badTaskTime", "2");
//			String result=velocityService.renderBody(model);
//			System.out.println(result);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test2() {
//		try{
////			pushServiceImpl.pushTaskService(25, PushTemplatePo.STATUS.FEEKBACK,14);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//}

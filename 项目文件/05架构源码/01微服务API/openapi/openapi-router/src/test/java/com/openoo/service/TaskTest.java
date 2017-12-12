//package com.openoo.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.jiuwu.openoo.common.openapi.utils.DateUtils;
//import com.jiuwu.openoo.service.task.ITaskService;
//import com.jiuwu.openoo.service.task.impl.TaskManager;
//import com.jiuwu.openoo.service.task.impl.TaskServiceImpl;
//
///**
// * 消息推送
// * @author eason
// *
// */
//public class TaskTest {
//	private ClassPathXmlApplicationContext ac;
//	private TaskManager taskManager;
//	@Before
//	public void setUp() throws Exception {
//		ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
//		taskManager = (TaskManager)ac.getBean("taskManager");
//	}
//
//	@Test
//	public void test1() {
//		try{
//			taskManager.createTaskCorn(45, DateUtils.parse("2015-08-28 11:34:49", DateUtils.YMD_DASH_WITH_TIME),DateUtils.parse("2015-08-28 11:35:49", DateUtils.YMD_DASH_WITH_TIME));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test2(){
//		ac = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
////		ITaskService taskServiceImpl = ac.getBean("taskServiceImpl", requiredType);
//	}
//}

//package com.jiuwu.openoo.service.demo.impl;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.stereotype.Service;
//
//import com.jiuwu.openoo.service.demo.DemoService;
//import com.openapi.model.request.demo.DemoRequest;
//import com.openapi.model.response.demo.DemoResponse;
//
///**
// * Demo实现类
// * @author lishun
// *
// */
//@Service("demoService")
//public class DemoServiceImpl implements DemoService{
//	private Log log = LogFactory.getLog(getClass());
//
//	@Override
//	public DemoResponse test(DemoRequest request) {
//		System.out.println(request);
//		DemoResponse response=new DemoResponse();
//		response.setResult("demo返回结果111111111111111111111111");
//		return response;
//	}
//	
//}

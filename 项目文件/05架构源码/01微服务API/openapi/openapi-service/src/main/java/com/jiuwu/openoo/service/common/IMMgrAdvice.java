//package com.jiuwu.openoo.service.common;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import model.user.UserInfoPo;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jiuwu.openoo.dao.mapper.push.method.PushTemplatePoMapper;
//import com.jiuwu.openoo.dao.mapper.task.method.TaskMapper;
//import com.jiuwu.openoo.dao.mapper.user.method.UserMapper;
//import com.jiuwu.openoo.service.push.IIMService;
//import com.openapi.model.request.base.UserCommonResponse;
//import com.openapi.model.request.user.RegisterUserRequest;
//import com.openapi.model.request.user.UpdatePwdRequest;
//import com.openapi.model.response.user.UpdatePwdResponse;
//
///**
// * 环信即时通信处理
// * @author lishun
// *
// */
//public class IMMgrAdvice {
//	private Log log = LogFactory.getLog(getClass());
//	
//	@Autowired
//	private IIMService imServiceImpl;
//	@Autowired
//	private UserMapper userMapper;
//	@Autowired
//	private TaskMapper taskMapper;
//	@Autowired
//	private PushTemplatePoMapper pushTemplatePoMapper;
//	
//    public Object process(ProceedingJoinPoint point) throws Throwable {
//    	log.info("@Around：执行环信接口目标方法之前...");
//        //访问目标方法的参数：
//        Object[] args = point.getArgs();
//        if (args != null && args.length > 0 ) {
//        	if(args[0] instanceof RegisterUserRequest){
//        	  //用改变后的参数执行目标方法
//              Object returnValue = point.proceed(args); 
//              UserCommonResponse response=(UserCommonResponse)returnValue;
//			   if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
//				   Map<String, Object> dataNode=new HashMap<String, Object>();
//				   RegisterUserRequest request=(RegisterUserRequest)args[0];
//				   dataNode.put("userId", response.getUserId());
//				   UserInfoPo po=new UserInfoPo();
//	               po.setUserId(response.getUserId());
//	               po=userMapper.getUserByAccount(po);
//				   dataNode.put("username", request.getPhone());
//				   dataNode.put("password", request.getPassword());
//				   dataNode.put("nickname", po.getNickName());
//				   imServiceImpl.createNewIMUserSingle(dataNode);
//			   }	
//              return returnValue;
//        	}else if(args[0] instanceof UpdatePwdRequest){
//        		//用改变后的参数执行目标方法
//                Object returnValue = point.proceed(args); 
//                UpdatePwdResponse response=(UpdatePwdResponse)returnValue;
//   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
//   				   Map<String, Object> dataNode=new HashMap<String, Object>();
//   				   UpdatePwdRequest request=(UpdatePwdRequest)args[0];
//   				   UserInfoPo po=new UserInfoPo();
//	               po.setUserId(request.getUserId());
//	               po=userMapper.getUserByAccount(po);
//	               
//   				   dataNode.put("userId", request.getUserId());
//   				   dataNode.put("username", po.getPhone());
//   				   dataNode.put("newpassword", request.getNewPwd());
//   				   dataNode.put("oldpassword", po.getPassword());
//   				   imServiceImpl.modifyIMUserPwdByUserName(po.getPhone(), dataNode);
//   			   }else{
//   				   response.setResult("修改密码失败，请重试");
//   				   return response;
//   			   }
//               return returnValue;
////         	}else if(args[0] instanceof HurryUpRequest){
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                HurryUpResponse response=(HurryUpResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	HurryUpRequest request=(HurryUpRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	PushTemplatePo templatePo=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.HURRY_UP);
////   			    	imServiceImpl.sendIMMsg("tachui_client",po.getPhone(),templatePo.getContext());
////   			   }	
////               return returnValue;
////         	}else if(args[0] instanceof HunterAuditRequest){
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                HunterAuditResponse response=(HunterAuditResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	HunterAuditRequest request=(HunterAuditRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送给申诉人(猎金人)：您的申述已提交成功，请等待，我们会及时与您联系 po=猎人
////   			    	PushTemplatePo templatePo1=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.AUDIT);
////   			    	imServiceImpl.sendIMMsg("notification_client",po.getPhone(),templatePo1.getContext());
////   			    	
////   			    	Map<String,Object> mapTask=new HashMap<String,Object>();
////   					mapTask.put("taskId", request.getTaskId());
////   					TaskPo taskPo=taskMapper.getTaskById(mapTask);
////   					po=new UserInfoPo();
////   			    	po.setUserId(taskPo.getBountyUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送给赏金人：您的任务退款申请猎金人${hunterName}没有同意，已经申述。您如果愿意支付赏金，请选择“评价并支付”，如果继续退款请不做操作，Ta帮客服稍后会与您联系!
////   					PushTemplatePo templatePo2=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.AUDIT_BOUNTY);
////   			    	imServiceImpl.sendIMMsg("notification_client",po.getPhone(),templatePo2.getContext());
////   			   }	
////               return returnValue;
////         	}else if(args[0] instanceof AgreeRefundRequest){ //同意退款接口
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                AgreeRefundResponse response=(AgreeRefundResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	AgreeRefundRequest request=(AgreeRefundRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送给赏金人：【退款成功】您的退款申请猎人${hunterName}已同意，赏金将在24小时内转入您的账户中！
////   			    	PushTemplatePo templatePo1=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.REFUND_SUCCESS);
////   			    	imServiceImpl.sendIMMsg("notification_client",po.getPhone(),templatePo1.getContext());
////   			    	
////   			    	Map<String,Object> mapTask=new HashMap<String,Object>();
////   					mapTask.put("taskId", request.getTaskId());
////   					TaskPo taskPo=taskMapper.getTaskById(mapTask);
////   					po=new UserInfoPo();
////   			    	po.setUserId(taskPo.getBountyUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送给赏金人：退款到账提醒
////   					PushTemplatePo templatePo2=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.REFUND_TOACCOUNT);
////   			    	imServiceImpl.sendIMMsg("zhifu_client",po.getPhone(),templatePo2.getContext());
////   			   }	
////               return returnValue;
////         	}else if(args[0] instanceof BountyRefundRequest){ //赏金申请退款接口
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                BountyRefundResponse response=(BountyRefundResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	BountyRefundRequest request=(BountyRefundRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送给赏金人：您的退款申请已经通知猎金人，请耐心等待!
////   			    	PushTemplatePo templatePo1=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.BOUNTY_REFUND);
////   			    	imServiceImpl.sendIMMsg("notification_client",po.getPhone(),templatePo1.getContext());
////   			    	
////   			    	Map<String,Object> mapTask=new HashMap<String,Object>();
////   					mapTask.put("taskId", request.getTaskId());
////   					TaskPo taskPo=taskMapper.getTaskById(mapTask);
////   					po=new UserInfoPo();
////   			    	po.setUserId(taskPo.getBountyUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//推送猎人：悬赏人${bountyName}正在申请退款，您如果同意退款请选择“同意退款”，系统会将赏金返回给悬赏人；您如果不同意退款，请选择“申述”，Ta帮收到申述后，会第一时间与您联系！
////   					PushTemplatePo templatePo2=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.HUNTER_REFUND);
////   			    	imServiceImpl.sendIMMsg("notification_client",po.getPhone(),templatePo2.getContext());
////   			   }	
////               return returnValue;
////         	}else if(args[0] instanceof WithdrawOrderRequest){ //申请提现 saveWithdrawOrder
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                WithdrawOrderResponse response=(WithdrawOrderResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	WithdrawOrderRequest request=(WithdrawOrderRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	//对提款用户推送消息：您发起了零钱提现
////   			    	PushTemplatePo templatePo1=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.WITHDRAW);
////   			    	imServiceImpl.sendIMMsg("zhifu_client",po.getPhone(),templatePo1.getContext());
////   			   }	
////               return returnValue;
////         	}else if(args[0] instanceof CheckTaskRequest){ //赏金到帐提醒：(评价并支付后，猎人会收到赏金。推送消息:)
////        		//用改变后的参数执行目标方法
////                Object returnValue = point.proceed(args); 
////                CheckTaskResponse response=(CheckTaskResponse)returnValue;
////   			    if(response.getSuccessCount()>=1){//如果注册成功，同步环信登陆
////   			    	HurryUpRequest request=(HurryUpRequest)args[0];
////   			    	UserInfoPo po=new UserInfoPo();
////   			    	po.setUserId(request.getUserId());
////   			    	po=userMapper.getUserByAccount(po);
////   			    	PushTemplatePo templatePo=pushTemplatePoMapper.selectByPrimaryKey(PushTemplatePo.STATUS.BOUNTY_TOACCOUNT);
////   			    	imServiceImpl.sendIMMsg("zhifu_client",po.getPhone(),templatePo.getContext());
////   			   }	
////               return returnValue;
//         	}
//        }
//        log.info("@Around：执行环信接口目标方法之后...");
//        log.info("@Around：被织入环信接口的目标对象为：" + point.getTarget());
//        return null;
//    }
//}

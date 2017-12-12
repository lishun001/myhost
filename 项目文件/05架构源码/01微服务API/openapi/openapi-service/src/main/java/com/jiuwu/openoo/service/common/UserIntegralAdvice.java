//package com.jiuwu.openoo.service.common;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jiuwu.openoo.service.user.IUserIntegralService;
//import com.openapi.model.request.base.UserCommonResponse;
//import com.openapi.model.request.task.CheckTaskRequest;
//import com.openapi.model.request.task.LocationTaskRequest;
//import com.openapi.model.request.task.MultipleTaskRequest;
//import com.openapi.model.request.task.PublishTaskRequest;
//import com.openapi.model.request.task.RePublishTaskRequest;
//import com.openapi.model.request.task.SpecificTaskRequest;
//import com.openapi.model.request.user.UserLoginRequest;
//import com.openapi.model.request.user.RegisterUserRequest;
//import com.openapi.model.response.task.CheckTaskResponse;
//import com.openapi.model.response.task.LocationTaskResponse;
//import com.openapi.model.response.task.MultipleTaskResponse;
//import com.openapi.model.response.task.PublishTaskResponse;
//import com.openapi.model.response.task.RePublishTaskResponse;
//import com.openapi.model.response.task.SpecificTaskResponse;
//import com.openapi.model.response.user.UserLoginResponse;
//
///**
// * 切面方法：用于计算积分
// * @author Harry
// *
// */
//public class UserIntegralAdvice {
//	private Log log = LogFactory.getLog(getClass());
//	
//	@Autowired
//	private IUserIntegralService userIntegralService;
//    public Object process(ProceedingJoinPoint point) throws Throwable {
//    	log.info("@Around：执行目标方法之前...");
//        //访问目标方法的参数：
//        Object[] args = point.getArgs();
//        if (args != null && args.length > 0 ) {
//        	//登录积分
//        	if( args[0] instanceof UserLoginRequest){
//        	//用改变后的参数执行目标方法
//              Object returnValue = point.proceed(args); 
//              UserLoginResponse response=(UserLoginResponse)returnValue;
//			   if(response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByLogin(response.getUserId());
//			   }	
//              return returnValue;
//        	}else if(args[0] instanceof PublishTaskRequest){ //发布积分 
//				PublishTaskRequest request = (PublishTaskRequest) args[0];
//				Object returnValue = point.proceed(args);
//				PublishTaskResponse  response = (PublishTaskResponse) returnValue;
//				if(response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByPublishTask(request.getUserId());
//				}
//				return returnValue;
//        	}else if(args[0] instanceof RePublishTaskRequest){ //重新发布积分
//        		RePublishTaskRequest request = (RePublishTaskRequest) args[0];
//				Object returnValue = point.proceed(args);
//				RePublishTaskResponse  response = (RePublishTaskResponse) returnValue;
//				if(response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByPublishTask(request.getUserId());
//				}	
//				return returnValue;	
//        	}else if(args[0] instanceof CheckTaskRequest){//完成任务积分 
//        		CheckTaskRequest request = (CheckTaskRequest) args[0];
//				Object returnValue = point.proceed(args);
//				CheckTaskResponse  response = (CheckTaskResponse) returnValue;
//				if(response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByFinishTask(request.getUserId());
//				}
//				return returnValue;	
//        	}else if(args[0] instanceof RegisterUserRequest){//注册积分
//        		Object returnValue = point.proceed(args); 
//        		UserCommonResponse response = (UserCommonResponse) returnValue;
//				if(response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByRegist(response.getUserId());
//				}
//        		return returnValue;	
//        	}else if(args[0] instanceof LocationTaskRequest){//创建并发布任务
//        		LocationTaskRequest request = (LocationTaskRequest) args[0];
//        		Object returnValue = point.proceed(args); 
//        		LocationTaskResponse response = (LocationTaskResponse) returnValue;
//        		//如果是创建并发布任务，并且发布任务成功了。
//				if(request.getType()==1 && response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByPublishTask(request.getUserId());
//				}
//        		return returnValue;	
//        	}else if(args[0] instanceof MultipleTaskRequest){////创建并发布多人任务
//        		MultipleTaskRequest request = (MultipleTaskRequest) args[0];
//        		Object returnValue = point.proceed(args); 
//        		MultipleTaskResponse response = (MultipleTaskResponse) returnValue;
//				if(request.getType()==1  && response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByPublishTask(request.getUserId());
//				}
//        		return returnValue;	
//        	}else if(args[0] instanceof SpecificTaskRequest){////创建并发布指定
//        		SpecificTaskRequest request = (SpecificTaskRequest) args[0];
//        		Object returnValue = point.proceed(args); 
//        		SpecificTaskResponse response = (SpecificTaskResponse) returnValue;
//				if(request.getType()==1 && response.getSuccessCount()>=1){//如果接口执行成功，则增加积分
//					userIntegralService.addIntegralByPublishTask(request.getUserId());
//				}
//        		return returnValue;	
//        	}
//        	
//        }
//        log.info("@Around：执行目标方法之后...");
//        log.info("@Around：被织入的目标对象为：" + point.getTarget());
//        return null;
//    }
//}

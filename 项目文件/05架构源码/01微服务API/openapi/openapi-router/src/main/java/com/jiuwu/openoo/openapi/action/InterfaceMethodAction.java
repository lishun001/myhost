package com.jiuwu.openoo.openapi.action;

import java.lang.reflect.Type;

import model.ApiMethod.OoApiMethodCfgModel;
import model.ApiMethod.OoApiMethodModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.jiuwu.openoo.common.openapi.utils.ReflectUtil;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodCfgMapper;
import com.jiuwu.openoo.dao.mapper.kamailio.method.OoApiMethodMapper;
import com.opensymphony.xwork2.ActionSupport;

public class InterfaceMethodAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	private final Log log = LogFactory.getLog(getClass());
	@Autowired
	private OoApiMethodMapper ooApiMethodMapper;
	@Autowired
	private OoApiMethodCfgMapper ooApiMethodCfgMapper;
	/** 接口名称 */
	private String interfaceName;
	/** 方法名称*/
	private String serviceName;
	/** 方法名*/
    private String methodName;
    /** 方法备注 */
    private String methodRemark;
    /** 方法的级别*/
    private String methodLevel;
	/** 接口的类型 */
    private String methodType;
    /** message信息*/
    private String msg;
    

	public String initMethod() {
		return SUCCESS;
	}
	public String registerMethod(){
		log.info("注册接口");
		OoApiMethodModel method = new OoApiMethodModel(Integer.parseInt(methodType),interfaceName,methodName,methodRemark,Integer.parseInt(methodLevel));
		OoApiMethodCfgModel methoCf = new OoApiMethodCfgModel();
		String cfgValue = null;
		String errorMsg = null;
		try {
			cfgValue = addMethodByReflect(serviceName,methodName);
		} catch (Exception e) {
			errorMsg = e.getMessage();
		}
		if(StringUtils.isNoneBlank(errorMsg)){
			msg = errorMsg;
		}else{
			if(StringUtils.isNoneBlank(cfgValue)){
				methoCf.setCfgValue(cfgValue);
				//添加method
				method.setMethodCfg("1");
				method.setMethodType(1);
				ooApiMethodMapper.addModel(method);
				methoCf.setMethodId(method.getId());
			    ooApiMethodCfgMapper.addModel(methoCf);
			    msg = "注册接口成功";
			}else{
				msg = "注册接口失败";
			}
		}	
		ServletActionContext.getRequest().setAttribute("msg",msg);
		return SUCCESS;
	}
	public String addMethodByReflect(String serviceName,String methodName){
		
		String returnMsg = null;
		Class clazz = null;
		String requestString = null;
		String serName = null;
		Class[] classs = null;
		String tempServiceName = null;
		//获取request的地址
		if(StringUtils.isNotBlank(serviceName)&&StringUtils.isNotBlank(methodName)){
				
					try {
						clazz = Class.forName(serviceName);
						tempServiceName = serviceName.substring(serviceName.lastIndexOf(".")+1);
						classs = ReflectUtil.getMethodParamTypes(clazz.newInstance(), methodName);
	  				} catch (Exception e) {
						throw new RuntimeException("not find this serviceImpl");
					}	
					if(classs!=null && classs.length>0){
						if(classs.length>1){
							throw new RuntimeException("["+methodName+"]"+"方法有多个参数");
						}else{
							requestString = classs[0].toString().substring(6);
						}
						
					}else{
						throw new RuntimeException("没有找到["+methodName+"]方法或["+methodName+"]方法没有参数");
					}
					//获取此实现类的接口
					Type[] types = clazz.getGenericInterfaces();
					String[]strings = null;
					String temp = null;
					if(types!=null&&types.length>0){
						strings = new String[types.length];
						int i = 0;
						for(Type type:types){
							temp = type.toString().substring(type.toString().lastIndexOf(".")+1);
							//判断此实现类是否包含此接口(字符串包含)
							if(tempServiceName.contains(temp)){
								strings[i] = temp;
								i++;
							}
						}
						if(i==1){
							serName = temp.substring(0, 1).toLowerCase() + temp.substring(1);
						}else if(i==0){
							throw new RuntimeException("无法匹配到相似的接口");
						}else{
							throw new RuntimeException("获取到多个相似的接口");
						}
					}else{
						throw new RuntimeException("此实现类没有继承接口");
					}
			
		}else{
			throw new RuntimeException("service类名或者方法名为空");
		}
		return "local;"+serName+";"+methodName+";"+requestString;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getMethodRemark() {
		return methodRemark;
	}
	public void setMethodRemark(String methodRemark) {
		this.methodRemark = methodRemark;
	}
	public String getMethodLevel() {
		return methodLevel;
	}
	public void setMethodLevel(String methodLevel) {
		this.methodLevel = methodLevel;
	}
}

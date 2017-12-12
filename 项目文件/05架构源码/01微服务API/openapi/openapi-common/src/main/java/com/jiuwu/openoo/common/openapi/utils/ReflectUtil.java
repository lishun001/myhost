package com.jiuwu.openoo.common.openapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/** 反射工具类  */
public class ReflectUtil {

	/**
	 * 根据方法名称取得反射方法的参数类型(没有考虑同名重载方法使用时注意)
	 * @param obj         类实例  
	 * @param methodName  方法名
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class[]  getMethodParamTypes(Object classInstance, 
	    String methodName) throws ClassNotFoundException{
	    Class[] paramTypes = null;
	    Method[]  methods = classInstance.getClass().getMethods();//全部方法
	    for (int  i = 0;  i< methods.length; i++) {
	        if(methodName.equals(methods[i].getName())){//和传入方法名匹配 
	            Class[] params = methods[i].getParameterTypes();
	            paramTypes = new Class[ params.length] ;
	            for (int j = 0; j < params.length; j++) {
	                paramTypes[j] = Class.forName(params[j].getName());
	            }
	            break; 
	        }
	    }
	    return paramTypes;
	}
	/**
	 * 
	  * @Description: 根据一个list得到另外一个list(某个字段组成)
	  * TODO
	  * @param field
	  * @param list
	  * @return
	  * @author Feng Chao
	  * @date 2015-6-12
	 */
	public static List<Object> getListByField(String field ,List<?> list,Class<?> clazz){
		
		List<Object> objList = null;
		boolean isHave = false;
		if(StringUtils.isNoneBlank(field)){
			Field[] fields = clazz.getDeclaredFields();
			for(Iterator<Field> it = Arrays.asList(fields).iterator();it.hasNext();){
				 Field fie = it.next();
				 if(fie.getName().toUpperCase().equals(field.toUpperCase())){
					 isHave = true;
					 break;
				 }
			}
			//如果包含此字段，则遍历数据
			if(isHave){
				if(list != null && !list.isEmpty()){
					objList = new ArrayList<Object>();
					for(Object object : list){
						if(clazz.isInstance(object)){
							try {
						        Method method = clazz.getMethod("get"+field.replaceFirst(field.substring(0,1),field.substring(0,1).toUpperCase()));	
						        Object obj = method.invoke(object);
						        objList.add(obj);
							} catch (Exception e) {
								// TODO: handle exception
							}
							
						}
					}
				}
			}
		}
		
		return objList;
	}
	
	public static void main(String[] args) {
		
		List<Userss> list = new ArrayList<Userss>();
		Userss user = new Userss();
		user.setA(1);
		user.setName("abc");
		Userss user2 = new Userss();
		user2.setA(2);
		user.setName("def");
		Userss user3 = new Userss();
		user3.setA(3);
		user3.setName("hhh");
		list.add(user);
		list.add(user2);
		list.add(user3);
		getListByField("a",list,Userss.class);
	}
}

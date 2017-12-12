//package com.jiuwu.openoo.service.common;
//
//import java.io.StringReader;
//import java.io.StringWriter;
//import java.util.Map;
//import java.util.Properties;
//
//import model.push.PushTemplatePo;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;
//import org.apache.velocity.app.VelocityEngine;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.jiuwu.openoo.dao.mapper.push.method.PushTemplatePoMapper;
//
///**
// * 
// * @author Eason
// */
//@Service("velocityService")
//public class VelocityService {
//	public static final String ENCODE = "UTF-8";
//	@Autowired
//	private VelocityEngine velocityEngine;
//	@Autowired
//	private PushTemplatePoMapper pushTemplatePoMapper;
//	
//	public String renderBody(Map<String, Object> model) throws Exception {
//		Properties p = new Properties();
//		p.setProperty("resource.loader", "class");
//		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//		Velocity.init(p);
//        VelocityEngine velocityEngine=new VelocityEngine(p);
//        VelocityContext context=new VelocityContext(model);
//        StringWriter writer=new StringWriter();
//        PushTemplatePo templatePo=pushTemplatePoMapper.selectByPrimaryKey((String)model.get("code"));
//        String template=templatePo.getContext();
//        StringReader sr=new StringReader(template);
//        //读取数据库的vm模板
//        velocityEngine.evaluate(context, writer, ENCODE, sr);
//        //经测试：Weblogic不支持这种加载模版的方式，Jetty和Tomcat支持
////		return VelocityEngineUtils.mergeTemplateIntoString(getVelocityEngine(),template, ENCODE, model);
//        //从src目录下加载vm模板
////      velocityEngine.mergeTemplate(template, ENCODE, context, writer);
//        return writer.toString();
//	}
//
//	public String renderSubject(Map<String, Object> model) throws Exception {
//		StringWriter writer = new StringWriter();
//		VelocityContext velocityContext = new VelocityContext(model);
//		PushTemplatePo templatePo=pushTemplatePoMapper.selectByPrimaryKey((String)model.get("code"));
//	    String template=templatePo.getContext();
//		Template template0 = velocityEngine.getTemplate(template,ENCODE);
//		template0.merge(velocityContext, writer);
//		Object subject = velocityContext.get("subject");
//		if (subject instanceof String) {
//			return (String) subject;
//		}
//		return null;
//	}
//	
//
//}

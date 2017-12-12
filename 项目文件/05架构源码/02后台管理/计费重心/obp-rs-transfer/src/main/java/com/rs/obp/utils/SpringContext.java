/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author wangxinming
 */
public class SpringContext {

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);
    private static ClassPathXmlApplicationContext ctx;

    /**
     * 加载spring配置
     */
    public static void inizSpringCtx(String filePath) {
        ctx = new ClassPathXmlApplicationContext(filePath);
        ctx.registerShutdownHook();
        logger.info("spring配置文件加载完毕");
    }

    /**
     * 根据beanId获取bean
     *
     * @param beanId
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId, Class<T> interfaceClass) {
        return (T) ctx.getBean(beanId);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.utils;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zhaowx
 */
public class MapperGeneratorer {

    static Logger logger = LoggerFactory.getLogger(MapperGeneratorer.class);
    //org.mybatis.spring.SqlSessionTemplate
    private static SqlSession sqlSession;

    static {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

            sqlSession = (SqlSession) ctx.getBean("sqlSession");
        } catch (Exception e) {
            logger.error("get sqlSessionFactory error...", e);
        }
    }

    public static <T> T getMapper(Class<T> c) {
//        return (T) sessionFactory.openSession().getMapper(c);
        return (T) sqlSession.getMapper(c);
    }
}

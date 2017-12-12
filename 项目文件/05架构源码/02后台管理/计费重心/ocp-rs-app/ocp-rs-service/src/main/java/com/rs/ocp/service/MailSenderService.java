/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author zhaoweixing
 */
public class MailSenderService {
    
    JavaMailSender javaMailSender;
    SimpleMailMessage simpleMailMessage;
    private String user_propties;
    
    public void sendMail(String receiver, String subject, String message) {
        // 建立邮件消息
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        // 发送邮件
        javaMailSender.send(simpleMailMessage);
    }
    
    public void autoSendMail(String subject, String message) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(user_propties));
        Enumeration enum1 = props.keys();
        while (enum1.hasMoreElements()) {
            String name = (String) enum1.nextElement();
            String e_mail = props.getProperty(name);
            sendMail(e_mail, subject, message);
        }
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        MailSenderService sender = (MailSenderService) ctx.getBean("mailSenderService");
//        sender.sendMail("51737242@qq.com", "测试邮件预警", "游戏服务器与计费连接断开,请检查!");
        sender.autoSendMail("计费中心预警", "客户端心跳超时, 请检查!");
    }
    
    public void setUser_propties(String user_propties) {
        this.user_propties = user_propties;
    }
    
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }
}

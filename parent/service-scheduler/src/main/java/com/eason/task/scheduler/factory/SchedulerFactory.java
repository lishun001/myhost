package com.eason.task.scheduler.factory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class SchedulerFactory {

    @Autowired
    private MyJobFactory myJobFactory;  //自定义的factory
    @Value("${quartz.config}")
    private String quartzConfig;

    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        factory.setJobFactory(myJobFactory);
        factory.setOverwriteExistingJobs(true);
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        System.out.println(quartzConfig);
        propertiesFactoryBean.setLocation(new ClassPathResource(quartzConfig));

        return propertiesFactoryBean.getObject();
    }

    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }
}

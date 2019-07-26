package com.vd.job;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Desc: 启动类
 * Author: VinDe
 * Date: Create in 2019/7/26
 */
@SpringBootApplication(exclude = {MybatisAutoConfiguration.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.vd.job","com.vd.common"})
public class JobApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

}

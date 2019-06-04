package com.kevinwong.config.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * @Program: King-Admin
 * @Class: SpringSessionConfig
 * @Description: SpringSession 配置
 * @Author: Eastascend <EastascendWang@gmail.com>
 * @Date: 2019-06-04 16:40
 **/
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)  //session过期时间  如果部署多机环境,需要打开注释
@ConditionalOnProperty(prefix = "king", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfig {
}

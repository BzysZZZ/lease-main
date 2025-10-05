package com.qianlou.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@Configuration
@ComponentScan(basePackages = "com.qianlou.common")
public class WebConfig {
}

package com.example.onepractice1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.onepractice1")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {

}

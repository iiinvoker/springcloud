package com.ytx.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyRule {
    @Bean
    public IRule myRule(){
        return new RibbonRule();
    }
}

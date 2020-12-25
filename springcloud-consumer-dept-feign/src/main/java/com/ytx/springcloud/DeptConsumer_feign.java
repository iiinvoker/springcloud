package com.ytx.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//ribbon和eureka整合以后，客户端直接调用方法,不用关心ip地址和端口号
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ytx.springcloud"})
public class DeptConsumer_feign {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer_feign.class,args);
    }
}

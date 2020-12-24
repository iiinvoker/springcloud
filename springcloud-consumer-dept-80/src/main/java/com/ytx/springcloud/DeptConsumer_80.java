package com.ytx.springcloud;

import com.ytx.MyRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


//ribbon和eureka整合以后，客户端直接调用方法,不用关心ip地址和端口号
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}

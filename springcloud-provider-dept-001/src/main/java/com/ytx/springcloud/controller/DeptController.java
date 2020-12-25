package com.ytx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ytx.springcloud.pojo.Dept;
import com.ytx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //得到具体微服务的信息
    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping("dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("dept/get/{id}")
    public Dept get(@PathVariable("id") int id){
        Dept dept=deptService.queryById(id);
        if(dept==null){
            throw new RuntimeException("id=>"+id+"不存在该用户或无法找到信息");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") int id){
        Dept dept=new Dept("");
        dept.setDeptno(id);
        dept.setDname("id=>"+id+"不存在该用户或无法找到信息");
        dept.setDb_source("no record in database");
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获的微服务列表的清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>service"+services);
        List<ServiceInstance> instances=discoveryClient.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance:instances) {
            System.out.println(
                    instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}

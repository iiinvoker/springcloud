package com.ytx.springcloud.service;

import com.ytx.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientFallbackFactory implements FallbackFactory {

    @Override
    public  DeptClientService create(Throwable throwable){
        return new DeptClientService() {
            @Override
            public Dept queryById(int id) {
                Dept dept=new Dept("");
                dept.setDeptno(id);
                dept.setDname("id=>"+id+"服务已经被降级，无法继续提供该服务");
                dept.setDb_source("this service is not supported in short term");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}

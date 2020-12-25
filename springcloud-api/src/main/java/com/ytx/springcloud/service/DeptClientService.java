package com.ytx.springcloud.service;

import com.ytx.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") int id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}

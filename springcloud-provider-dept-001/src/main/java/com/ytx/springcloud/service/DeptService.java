package com.ytx.springcloud.service;

import com.ytx.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(int id);

    public List<Dept> queryAll();
}

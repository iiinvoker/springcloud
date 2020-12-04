package com.ytx.springcloud.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

//必需实体类序列化
//完成类表关系映射

@Data
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private int deptno;
    private int dname;

    //这个数据存在哪个数据库，一个服务一个数据库，一个数据多个数据库
    private int db_source;

    public Dept(int dname) {
        this.dname = dname;
    }

}

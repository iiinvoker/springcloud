package com.ytx.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//必需实体类序列化
//完成类表关系映射

@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String db_source;
    //这个数据存在哪个数据库，一个服务一个数据库，一个数据多个数据库
    public Dept(String dname) {
        this.dname = dname;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }
}

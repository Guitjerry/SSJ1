package com.csair.entity;

import javax.persistence.*;

/**
 * Created by mac on 16/12/18.
 * 供货商
 */
@Table(name = "supplier")
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private int status;
    @Column(name = "createtime")
    private String createtime;
    @Column(name = "sort")
    private int sort;//排序

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}

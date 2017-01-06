package com.csair.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 子类目
 * Created by dnys on 2016/11/16.
 */
@Entity
@Table(name="categorychildren")
public class CategoryChildren {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer sort;//排序
    private String code;
    private int categoryid;//主类目id
    private int status;//状态
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="sort")
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Column(name="code")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Column(name="categoryid")
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Column(name="status")


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

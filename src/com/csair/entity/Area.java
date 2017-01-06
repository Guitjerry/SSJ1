package com.csair.entity;

import javax.persistence.*;

/**
 * Created by dnys on 2016/12/1.
 */
@Entity
@Table(name="area")
public class Area {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private int status;
    @Column(name = "level")
    private int level;  //等级 1省 2市 3县
    @Column(name = "code")
    private String code;//编码
    @Column(name = "parentcode")
    private String parentcode;//父编码

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }
}

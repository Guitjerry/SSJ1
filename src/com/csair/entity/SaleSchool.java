package com.csair.entity;

import javax.persistence.*;

/**
 * 学校商家
 * Created by dnys on 2016/11/30.
 */
@Entity
@Table(name="saleSchool")
public class SaleSchool {
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private int status;//状态
    @Column(name = "provinceid")
    private int provinceid;
    @Column(name = "cityid")
    private int cityid;
    @Column(name = "townid")
    private int townid;
    @Column(name = "level")
    private int level;//人数
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getTownid() {
        return townid;
    }

    public void setTownid(int townid) {
        this.townid = townid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

package com.csair.entity;

import javax.persistence.*;

/**
 * Created by dnys on 2016/12/7.
 * 商品表
 */
@Table
@Entity(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="code")
    private String code;
    @Column(name="status")
    private int status;
    @Column(name="createtime")
    private String createtime;
    @Column(name="sort")
    private int sort;
    @Column(name="hotlevel")
    private int hotlevel;
    @Column(name="stock")
    private int stock;
    @Column(name="supplierid")
    private int supplierid;//供货商
    @Column(name="feellevel")
    private String feellevel;//口味
    @Column(name="photo")
    private String photo;
    @Column(name="categorychildrenid")
    private int categorychildrenid;//所属分类

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getHotlevel() {
        return hotlevel;
    }

    public void setHotlevel(int hotlevel) {
        this.hotlevel = hotlevel;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getFeellevel() {
        return feellevel;
    }

    public void setFeellevel(String feellevel) {
        this.feellevel = feellevel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCategorychildrenid() {
        return categorychildrenid;
    }

    public void setCategorychildrenid(int categorychildrenid) {
        this.categorychildrenid = categorychildrenid;
    }
}

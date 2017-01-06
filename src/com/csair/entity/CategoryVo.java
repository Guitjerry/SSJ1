package com.csair.entity;

/**
 * Created by dnys on 2016/11/17.
 */
public class CategoryVo {
    private int categorychildrenid;
    private int categoryid;
    private String categoryname;
    private String categorychildrenname;

    public CategoryVo(int categorychildrenid) {
        this.categorychildrenid = categorychildrenid;
    }

    public CategoryVo(String categoryname) {
        this.categoryname = categoryname;
    }

    public CategoryVo(int categorychildrenid, int categoryid, String categoryname, String categorychildrenname) {
        this.categorychildrenid = categorychildrenid;
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorychildrenname = categorychildrenname;
    }

    public int getCategorychildrenid() {
        return categorychildrenid;
    }

    public void setCategorychildrenid(int categorychildrenid) {
        this.categorychildrenid = categorychildrenid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorychildrenname() {
        return categorychildrenname;
    }

    public void setCategorychildrenname(String categorychildrenname) {
        this.categorychildrenname = categorychildrenname;
    }
}

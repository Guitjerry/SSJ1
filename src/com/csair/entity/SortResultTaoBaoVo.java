package com.csair.entity;

import java.util.List;

/**
 * Created by mac on 16/12/14.
 */
public class SortResultTaoBaoVo {
    private String photoUrl;//商品图片
    private String detailUrl;//详情地址
    private List<List<String>> detailphotourl;//评价图片
    private List<String> detailRate;//评价语言

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public List<List<String>> getDetailphotourl() {
        return detailphotourl;
    }

    public void setDetailphotourl(List<List<String>> detailphotourl) {
        this.detailphotourl = detailphotourl;
    }

    public List<String> getDetailRate() {
        return detailRate;
    }

    public void setDetailRate(List<String> detailRate) {
        this.detailRate = detailRate;
    }
}

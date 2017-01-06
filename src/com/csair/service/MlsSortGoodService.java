package com.csair.service;

import com.csair.entity.Mls_sortgood;
import com.csair.entity.SortResultTaoBaoVo;
import com.csair.entity.SortResultVo;

import java.util.List;

/**
 * Created by mac on 16/12/13.
 */
public interface MlsSortGoodService {
    /**
     * 定义地址匹配
     */
    public void saveMlsSortGood(Mls_sortgood mls_sortgood);

    /**
     * 查找所有记录
     * @return
     */
    public List<Mls_sortgood> listMlsSortgood();

    /**
     *
     * @param name 搜索名称
     * @param url 对应地址
     * @return
     */
    public SortResultVo findSortResult(String name,String url);

    /**
     *查找淘宝记录
     * @param goodname
     * @return
     */
    public List<SortResultTaoBaoVo> findSortResultTaoBao(String goodname);


}

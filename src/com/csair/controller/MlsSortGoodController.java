package com.csair.controller;

import com.csair.entity.Mls_sortgood;
import com.csair.entity.SortResultTaoBaoVo;
import com.csair.entity.SortResultVo;
import com.csair.service.MlsSortGoodService;
import com.csair.util.JsonUtilTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mac on 16/12/13.
 * 美丽说商品排序
 */
@Controller
@RequestMapping(value = "/mls")
public class MlsSortGoodController {
    @Autowired
    private MlsSortGoodService mlsSortGoodService;
    @RequestMapping(value = "addMlsSortGood")
    public void addMlsSortGood(Mls_sortgood mls_sortgood, HttpServletResponse response){
        if(mls_sortgood!=null){
            mlsSortGoodService.saveMlsSortGood(mls_sortgood);

        }
        if(mls_sortgood.getId()!=null&&mls_sortgood.getId()>0){
            try {
                JsonUtilTemp.returnSucessJson(response,"添加成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping(value = "listMlsSortGood")
    public String listMlsSortGood(HttpServletRequest request){
        List<Mls_sortgood> mls_sortgoodList = mlsSortGoodService.listMlsSortgood();
        if(mls_sortgoodList.size()>0){
            request.setAttribute("mls_sortgoodList",mls_sortgoodList);
        }
        return "mls/mlsSortGood";
    }
    @RequestMapping(value = "queryGoodSort")
    public void queryGoodSort(HttpServletResponse response,String goodname,String goodurl){
       SortResultVo resultVo = mlsSortGoodService.findSortResult(goodname,goodurl);
       if(resultVo!=null){
           JsonUtilTemp.returnObjAndSuccessJson(resultVo,response);
       }
    }
    @RequestMapping(value = "querySortResultTaoBao")
    public void querySortResultTaoBao(HttpServletResponse response,String goodname){
        List<SortResultTaoBaoVo> sortResultTaoBaoVos = mlsSortGoodService.findSortResultTaoBao(goodname);
        if(sortResultTaoBaoVos!=null&&sortResultTaoBaoVos.size()>0){
            JsonUtilTemp.returnObjAndSuccessJson(sortResultTaoBaoVos,response);
        }
    }

}

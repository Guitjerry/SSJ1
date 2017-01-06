package com.csair.service.Impl;

import com.csair.entity.Mls_sortgood;
import com.csair.entity.SortResultTaoBaoVo;
import com.csair.entity.SortResultVo;
import com.csair.repository.MlsSortGoodRepository;
import com.csair.service.MlsSortGoodService;
import com.csair.util.JsopUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 16/12/13.
 */
@Service("mlsSortGoodService")
public class MlsSortGoodServiceImpl implements MlsSortGoodService{
    @Autowired
    private MlsSortGoodRepository mlsSortGoodRepository;
    private static final String SEACHTAPBAOFRONT="https://s.taobao.com/search?q";
    private static final String SEACHTAPBAOBACK="&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20161214&ie=utf8";

    public MlsSortGoodRepository getMlsSortGoodRepository() {
        return mlsSortGoodRepository;
    }

    public void setMlsSortGoodRepository(MlsSortGoodRepository mlsSortGoodRepository) {
        this.mlsSortGoodRepository = mlsSortGoodRepository;
    }

    @Override
    public void saveMlsSortGood(Mls_sortgood mls_sortgood) {
        mlsSortGoodRepository.save(mls_sortgood);
    }

    @Override
    public List<Mls_sortgood> listMlsSortgood() {
        return mlsSortGoodRepository.findAll();
    }

    @Override
    public SortResultVo findSortResult(String name,String url) {
        SortResultVo sortResultVo = null;
        int count = 0;
        Document document = JsopUtil.connect(url);
        Elements links = document.getElementsByClass("text-link");
        for(Element link:links){
            String urlname = link.text().trim();
            count++;
            if(name.equals(urlname)){
                sortResultVo = new SortResultVo();
                sortResultVo.setSort(count);
            }
        }
        return sortResultVo;

    }

    @Override
    public List<SortResultTaoBaoVo> findSortResultTaoBao(String goodname) {
        String searchurl = SEACHTAPBAOFRONT+goodname+SEACHTAPBAOBACK;
        Document document = JsopUtil.connect(searchurl);
        List<String> detailRate = new ArrayList<>();//详情评价
        List<List<String>> detailRatePhoto = new ArrayList<>();//详情评价图片
        Elements elements = document.getElementsByAttributeValue("class","J_ItemPicA");
        List<SortResultTaoBaoVo> sortResultTaoBaoVos = new ArrayList<SortResultTaoBaoVo>();
        for(Element element:elements){
            String detailurl = element.attr("data-href");
            Document detailDocument = JsopUtil.connect(detailurl);
            Elements detailRateElement = detailDocument.getElementsByClass("J_KgRate_ReviewContent");//获取详情评价div
            Elements detailRatePhotoElement = detailDocument.getElementsByClass("kg-photo-viewer-thumb-bar");


            for(int i=0;i<detailRateElement.size();i++){

                Element rateElement = detailRateElement.get(i);
                Element ratePhotoElement = detailRatePhotoElement.get(i);

                List<String> phoele = new ArrayList<String>();
                Elements photoElements = ratePhotoElement.children();
                if(photoElements.size()>0){
                    detailRate.add(rateElement.text().trim());
                    for(Element pel:photoElements){
                        String pjpg = pel.attr("src");
                        pjpg = pjpg.replace("jpg_40x40","jpg_400x400");
                        phoele.add(pjpg);
                        detailRatePhoto.add(phoele);
                    }
                }
                SortResultTaoBaoVo sortResultTaoBaoVo = new SortResultTaoBaoVo();
                sortResultTaoBaoVo.setDetailRate(detailRate);
                sortResultTaoBaoVo.setDetailphotourl(detailRatePhoto);
                sortResultTaoBaoVo.setPhotoUrl(detailurl);
                sortResultTaoBaoVo.setDetailUrl(searchurl);
                sortResultTaoBaoVos.add(sortResultTaoBaoVo);

            }



        }
        return  sortResultTaoBaoVos;

    }


}

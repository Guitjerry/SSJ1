package com.csair.controller;

import com.csair.entity.Area;
import com.csair.service.AreaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

/**
 * Created by dnys on 2016/12/1.
 */
@Controller
@RequestMapping(value="/init")
public class InitController {
    @Autowired
    AreaService areaService;
    @RequestMapping(value = "/initArea")
    public void initArea() {
        Document document = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/");
        //省
        Elements rowProvince = document.getElementsByClass("provincetr");
        for (Element provinceElement : rowProvince) {
            Elements select = provinceElement.select("a");
            for (Element province : select) {
                //跳转市地址
                String strurl = province.attr("abs:href");
                //省名称
                String provincename = province.select("a").text();
                //省id
                String idstr = strurl.substring(strurl.lastIndexOf("/") + 1, strurl.lastIndexOf("."));
                Area area = new Area();
                area.setCode(idstr);
                area.setName(provincename);
                area.setLevel(1);
                area.setStatus(1);
                areaService.saveArea(area);

                //市
                Document dos = connect(strurl);
                Elements cityProvince = dos.getElementsByClass("citytr");
                for (Element cityElement : cityProvince) {

                    String cityname = cityElement.select("td").last().text();
                    //区县
                    if("县".equals(cityname)){
                       String quurl = cityElement.select("td").last().select("a").attr("abs:href");
                        Document qudoc = connect(quurl);
                        Elements quElements = qudoc.getElementsByClass("countytr");
                        for(Element quEle:quElements){
                            Area quarea = new Area();
                            quarea.setCode(quEle.select("td").first().text().substring(0,6));
                            quarea.setParentcode(String.valueOf(Integer.valueOf(cityElement.select("td").first().text().substring(0,4))-1));
                            quarea.setStatus(1);
                            quarea.setName(quEle.select("td").last().text());
                            quarea.setLevel(3);
                            areaService.saveArea(quarea);
                        }

                    }
                   else if("市辖区".equals(cityname)){
                        Area cityArea = new Area();
                        cityname = provincename + "市辖区";
                        cityArea.setName(cityname);
                        cityArea.setStatus(1);
                        cityArea.setLevel(2);
                        cityArea.setCode(cityElement.select("td").first().text().substring(0,4));
                        cityArea.setParentcode(idstr);
                        areaService.saveArea(cityArea);

                    }else{
                        Area cityArea = new Area();
                        cityArea.setName(cityElement.select("td").last().text());
                        cityArea.setCode(cityElement.select("td").first().text().substring(0,4));
                        cityArea.setParentcode(idstr);
                        cityArea.setStatus(1);
                        cityArea.setLevel(2);
                        areaService.saveArea(cityArea);
                        String lquurl =  cityElement.select("td").last().select("a").attr("abs:href");
                        Document lqudoc = connect(lquurl);
                        Elements lquElements = lqudoc.getElementsByClass("countytr");

                        for(Element lquEle:lquElements){
                            Area quarea = new Area();
                            quarea.setCode(lquEle.select("td").first().text().substring(0,6));
                            quarea.setParentcode(String.valueOf(Integer.valueOf(cityElement.select("td").first().text().substring(0,4))));
                            quarea.setStatus(1);
                            quarea.setName(lquEle.select("td").last().text());
                            quarea.setLevel(3);
                            areaService.saveArea(quarea);
                        }

                    }


                }
            }
        }
    }
    @RequestMapping(value="/index")
    public String index(){
        return "index";

    }

    private static Document connect(String url)
    {
        if (url == null || url.isEmpty())
        {
            throw new IllegalArgumentException("The input url('" + url + "') is invalid!");
        }
        try
        {
            return Jsoup.connect(url).timeout(100 * 1000).get();
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

package com.csair.util;

import com.csair.entity.Area;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试jsop
 * Created by dnys on 2016/12/2.
 */
public class JsopTest {
    public static void main(String[] args) {
        List<HashMap<String,ArrayList<String>>> areas = new ArrayList<HashMap<String, ArrayList<String>>>();
        Document document = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/");
        Elements rowProvince = document.getElementsByClass("provincetr");
        for(Element provinceElement : rowProvince){
            Elements select = provinceElement.select("a");
            for(Element province : select){
                String  strurl = province.attr("abs:href");
                String provincename = province.select("a").text();
                String idstr = strurl.substring(strurl.lastIndexOf("/")+1,strurl.lastIndexOf("."));
                Area area = new Area();
                area.setId(Integer.valueOf(idstr));
                area.setName(provincename);
                area.setLevel(1);
                area.setStatus(1);


                Document dos = connect(strurl);

                Elements cityProvince = dos.getElementsByClass("citytr");
                for(Element cityElement : cityProvince){
                    Element citySelect = cityElement.select("td").last();
                    System.out.println(citySelect.text());

                }
            }


        }
//        for (Element provinceElement : rowProvince)// 遍历每一行的省份城市
//        {
//            Elements select = provinceElement.select("a");
//            for (Element province : select)// 每一个省份(四川省)
//            {
//                parseNextLevel(province, level + 1);
//            }
//        }
    }

    public static void connectNext(String url){

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

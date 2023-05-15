package org.example;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class WeatherProcess implements PageProcessor {
    public static void main(String[] args){
        Spider spider = Spider.create(new WeatherProcess());
        spider.addUrl("http://www.weather.com.cn/weather40d/101030100.shtml");
        spider.addPipeline(new WeatherPipeline());
        spider.run();
    }
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //System.out.println(html);

        List<Selectable> weatherLinkNode = html.css("body > div.con.today.clearfix > div.right.fr > div:nth-child(11) > div > ul > li > a").nodes();
        int n=1;
        for (Selectable node:weatherLinkNode){
            WeatherInfo weatherInfo = new WeatherInfo();
            weatherInfo = parsObj(node);
            String temp=String.valueOf(n);
            n +=1;
            page.putField(temp,weatherInfo);
        }
    }
    private WeatherInfo parsObj(Selectable node) {
        WeatherInfo weatherInfo = new WeatherInfo();
        String area = node.css(".name","text").get();
        String temperature = node.css(".wd","text").get();
        String element = node.css(".weather","text").get();
        String tourismindex = node.css(".zs","text").get();
        weatherInfo.setArea(area);
        weatherInfo.setElement(element);
        weatherInfo.setTemperature(temperature);
        weatherInfo.setTourismindex(tourismindex);
        return weatherInfo;
    }

    private Site site = Site.me()
            .setCharset("utf8")
            .setTimeOut(10*1000)
            .setRetrySleepTime(3*1000)
            .setSleepTime(3)
            .setRetrySleepTime(3);
    @Override
    public Site getSite() {
        return site;
    }
}

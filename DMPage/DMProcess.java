package dongman;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class DMProcess implements PageProcessor {
    public static void main(String[] args) {
        //创建爬虫
        Spider spider=Spider.create(new DMProcess());
        spider.addUrl("https://ac.qq.com/?ref=clicli.com.cn");
        spider.addPipeline(new DMPipeline());
        spider.run();
    }
    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        //System.out.println(html);
        List<Selectable> DMLinkNode=html.css("#in-vip-wr > div.in-monrank-wr.clearfix > div.in-monrank-item > div.in-monrank-tab-con > div:nth-child(1) > ul > li").nodes();
        for(int i=1;i< DMLinkNode.size();i++){
            DMInfo dmInfo =new DMInfo();
            dmInfo =pardObj(DMLinkNode.get(i));
            String temp=String.valueOf(i);
            page.putField(temp,dmInfo);

        }

    }

    private DMInfo pardObj(Selectable node) {
        DMInfo dmInfo=new DMInfo();
        String name=node.css("li a > em.no1","text").get();
        String author=node.css("li a > em.no2","text").get();
        String ticket=node.css("li a > em.last","text").get();
        ticket=ticket.substring(0,ticket.length()-1);
        dmInfo.setName(name);
        dmInfo.setAuthor(author);
        dmInfo.setTicket(ticket);
        return dmInfo;


    }

    private Site site=Site.me()
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

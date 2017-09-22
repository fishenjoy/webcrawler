
package  biz;

import entity.NiuZa;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zzy on 2017/9/14.
 */
public class NiuZaProcessor implements PageProcessor {
    private Site site=Site.me().setRetryTimes(3).setSleepTime(100)
            .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0")  ;
    public static final String URL_LIST = "http://www\\.niuza\\.com\\/index(\\d+||^$)\\.html";
    @Override
    public void process(Page page){
        //先把页数链接加进去
        page.addTargetRequests(page.getHtml().css("div.wp-pagenavi").links().all());

        List<NiuZa> niuZaList=new ArrayList<>();
        //对列表和详情进行判断抓取
        if(page.getUrl().regex(URL_LIST).match()){
            //把每一页详情抓进去
            page.addTargetRequests(page.getHtml().xpath("//*[@id='home-left']/div/div/h2/a").links().all());
        }else{

            NiuZa niuZa=new NiuZa();
            //商品名称
            //System.out.println(page.getHtml().toString());
            niuZa.setProductname(page.getHtml().xpath("//*[@id='content-single']/div/h2/text()").toString());
            //商品价格
            String priceString= StringUtil.getPriceString(page.getHtml().xpath("//*[@id='content-single']/div/h2/span/text()").toString());
            //System.out.println(page.getHtml().xpath("//*[@id='home-left']/div/div/h2/a").links().all().toString());
            if(!StringUtil.isNullOrBlank(priceString)){
                niuZa.setPrice(Double.parseDouble(priceString));
            }

            //购买链接
            niuZa.setBuylink(page.getHtml().xpath("//*[@id='content-single']/div[2]/a[1]/@href").toString());
            //优惠券链接
            niuZa.setCouponlink(page.getHtml().xpath("//*[@id='content-single']/div[2]/a[2]/@href").toString());
            niuZa.setInsertdate(new Date());
            System.out.println(niuZa.toString());
            niuZaList.add(niuZa);



        }
        page.putField("niuza",niuZaList);
    }



    @Override
    public Site getSite(){
        return  site;
    }
}

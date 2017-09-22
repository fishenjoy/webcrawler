import biz.NiuZaPipeLine;
import biz.NiuZaProcessor;
import us.codecraft.webmagic.Spider;

/**
 * Created by zzy on 2017/9/14.
 */
public class NiuZaTest {
    public static  void main(String args[]){
        Spider.create(new NiuZaProcessor()).addUrl("http://www.niuza.com/index.html").addPipeline(new NiuZaPipeLine()).thread(5).run();
        System.out.println("本次新增插入"+NiuZaPipeLine.i);
    }
}

package biz;

import dao.MySqlDao;
import entity.NiuZa;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by zzy on 2017/9/14.
 */
public class NiuZaPipeLine implements Pipeline{
    public static int i=0;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<NiuZa> niuZaList=(List<NiuZa> )resultItems.get("niuza");
        for (NiuZa niuZa:niuZaList) {
            MySqlDao.insert(niuZa);
            i++;
        }


    }
}

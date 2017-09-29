package biz;

import dao.MySqlDao;
import entity.NiuZa;
import mapping.NiuZaMapperI;
import org.apache.ibatis.session.SqlSession;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by zzy on 2017/9/14.
 */
public class NiuZaPipeLine implements Pipeline{
    public static int i=0;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<NiuZa> niuZaList=(List<NiuZa> )resultItems.get("niuza");
        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        NiuZaMapperI niuZaMapperI=sqlSession.getMapper(NiuZaMapperI.class);
        for (NiuZa niuZa:niuZaList) {
            /*//替换为mybatis方式
            MySqlDao.insert(niuZa);*/
            niuZaMapperI.add(niuZa);
            i++;
        }
        sqlSession.close();

    }
}

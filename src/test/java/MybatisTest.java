import entity.NiuZa;
import mapping.NiuZaMapperI;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.MybatisUtil;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by zzy on 2017/9/22.
 */
public class MybatisTest {
    public static void main(String[] args){
        /*String resource="mybatisConf.xml";
        InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String statement="mapping.niuzaMapper.getNiuza";
        NiuZa niuZa=sqlSession.selectOne(statement,888);
        System.out.println(niuZa.toString());*/


        SqlSession sqlSession= MybatisUtil.getSqlSession(true);
        NiuZaMapperI niuZaMapperI=sqlSession.getMapper(NiuZaMapperI.class);
        //add
//        NiuZa niuZa=new NiuZa();
//        niuZa.setProductname("测试商品");
//        niuZa.setInsertdate(new Date());
//        niuZa.setPrice(9999);
//        int add=niuZaMapperI.add(niuZa);
//        sqlSession.close();
//        System.out.println(add);

//select
        NiuZa niuZa=niuZaMapperI.getById(888);
        sqlSession.close();
        System.out.println(niuZa.toString());


    }
}

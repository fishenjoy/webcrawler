import entity.NiuZa;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by zzy on 2017/9/22.
 */
public class MybatisTest {
    public static void main(String[] args){
        String resource="mybatisConf.xml";
        InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String statement="mapping.niuzaMapper.getNiuza";
        NiuZa niuZa=sqlSession.selectOne(statement,888);
        System.out.println(niuZa.toString());


    }
}

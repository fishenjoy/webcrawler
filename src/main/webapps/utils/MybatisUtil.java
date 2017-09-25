package utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by zzy on 2017/9/22.
 */
public class MybatisUtil {
    /**
     * 获取sqlsessionfactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        String resource="mybatisConf.xml";
        InputStream is=MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory;
    }
    /**
     * 获取sqlseesion
     */
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }
    /**
     * 获取SqlSession
     * @param isAutoCommit
     *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @return SqlSession
     */
    public static   SqlSession getSqlSession(boolean isAutoCommit){
        return  getSqlSessionFactory().openSession(isAutoCommit);
    }
}

package learning_java.util;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "config/mybatis-config.xml";

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream(resource));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession(true);
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }



}

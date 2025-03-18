package learning_java.数据库;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class mybatis_test {
    public static void main(String[] args) throws FileNotFoundException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("config/mybatis-config.xml"));
//        System.out.println(sqlSessionFactory);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            List<User> users = sqlSession.selectList("selectAllUser");
            users.forEach(System.out::println);
        }

    }
}

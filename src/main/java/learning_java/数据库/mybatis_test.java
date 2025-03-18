package learning_java.数据库;

import learning_java.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class mybatis_test {
    public static void main(String[] args) throws FileNotFoundException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("config/mybatis-config.xml"));
//        System.out.println(sqlSessionFactory);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            List<User> users = sqlSession.selectList("selectAllUser");
            users.forEach(System.out::println);
            User user = sqlSession.selectOne("selectUserById", 1);
            System.out.println(user);
            System.out.println("测试多查询");
            List<User> user1 = sqlSession.selectList("selectUserByAgeandgender", Map.of("age",22,"gender","Male"));
            user1.forEach(System.out::println);
            System.out.println("实体类模式查询");
            List<User> user2 = sqlSession.selectList("selectUserByAgeandgender",new Param(22,"Male"));
            user2.forEach(System.out::println);
            System.out.println("条件查询");
            List<User> user3 = sqlSession.selectList("selectUserAgeOver",18);
            user3.forEach(System.out::println);
            System.out.println("Map查询");
            Map<String,User> map = sqlSession.selectMap("selectUserAgeOver",18 ,"name");
            System.out.println(map);
            System.out.println("游标cursor查询");
            Cursor<User> cursor = sqlSession.selectCursor("selectUserAgeOver", 18);
//            cursor.forEach(System.out::println);
            for(User usercursor : cursor){
                System.out.println(usercursor);
                System.out.println(cursor.getCurrentIndex());
                System.out.println(usercursor.getName());
            }


        }

        }
        @Data
        @AllArgsConstructor
        static class Param{
         int age;
         String gender;
    }
}

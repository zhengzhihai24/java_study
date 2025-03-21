package learning_java.数据库;

import learning_java.mapper.TestMapper;
import learning_java.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class mybatis_test2 {
    public static void main(String[] args) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            System.out.println(mapper.selectUserById(1));



        }
    }
}

package learning_java.mapper;

import learning_java.entity.User;

import java.util.List;

public interface TestMapper {
    List<User> selectAllUser();

    User selectUserById(int id  );
}

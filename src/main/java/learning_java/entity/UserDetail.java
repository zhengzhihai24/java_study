package learning_java.entity;

import lombok.Data;

@Data
public class UserDetail {
    private Integer id;          // 详情ID，主键，自增
    private Integer studentId;   // 学生ID，外键，关联学生表
    private String address;      // 家庭住址
    private String phone;        // 联系电话
    private String email;        // 电子邮件
}

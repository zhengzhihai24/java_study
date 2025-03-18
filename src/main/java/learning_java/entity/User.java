package learning_java.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    int id ;
    String name ;
    int age ;
    String email ;
    Date createdAt ;
}

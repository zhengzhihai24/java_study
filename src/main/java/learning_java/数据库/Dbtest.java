package learning_java.数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbtest {
    public static void main(String[] args) {
//        DriverManager.drivers().forEach(System.out::println);

        String url = "jdbc:mysql://localhost:3306/study_db";
        String user = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("age"));
                System.out.println(resultSet.getString("gender"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

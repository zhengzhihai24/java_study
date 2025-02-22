package learning_java.entity;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int price;


}

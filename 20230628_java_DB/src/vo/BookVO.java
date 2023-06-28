package vo;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class BookVO {
	String id;
	String author;
	String title;
	String publisher;
	int price;

}

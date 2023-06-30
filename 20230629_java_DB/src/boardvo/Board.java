package boardvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import boardvo.Board;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Board {
	String id;
	String title;
	String contents;

}
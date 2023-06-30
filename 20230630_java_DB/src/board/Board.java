package board;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;

@Data
public class Board {
	private int num;
	private String writer, pwd;
	private String title;
	private Date board_date;
	private String content;
	private String currentTime;
	
	public Board() {
		this.board_date = new Date();
	}

	public String getCurrentTime() {
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.currentTime = df.format(this.board_date);
		
		return this.currentTime;
	}
	
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
}

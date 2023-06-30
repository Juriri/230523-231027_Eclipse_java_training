package board;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ServiceImpl implements Service {
	Dao dao = new DaoImpl();
	long day = System.currentTimeMillis();
	
	@Override
	public void write(Board b, String login_Id) {
		// TODO Auto-generated method stub
		try {
			if(login_Id != null) {
				dao.insert(b);
				System.out.println("게시글 등록 완료되었습니다. ");
			} else {
				System.out.println("로그인 먼저 진행해주세요. ");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public Board getArticle(int num) {
		// TODO Auto-generated method stub
		Board board = dao.select(num);
		
		if(board != null) {
			return dao.select(num);
		}
		
		System.out.println("해당 검색 결과가 없습니다. ");
		return null;
	}

	@Override
	public List getArticles() {
		// TODO Auto-generated method stub
		List<Board> board_arr = dao.selectAll();
		for(int i=0; i<board_arr.size(); i++) {
			System.out.println(board_arr.get(i));
		}
		
		return board_arr;
	}

	@Override
	public boolean editArticle(Board b) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("new title");
		String title = sc.next();
		
		System.out.print("new content");
		String content = sc.next();
		
		b.setTitle(title);
		b.setContent(content);
		
		b.setCurrentTime(b.getCurrentTime());
		
		int line = dao.update(b);

		return line<=0? false: true;
	}

	private java.sql.Date Date(long day2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delArticle(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}

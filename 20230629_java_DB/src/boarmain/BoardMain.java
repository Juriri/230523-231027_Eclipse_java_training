package boarmain;

import java.util.Scanner;

import boardservice.BoardService;
import boardvo.Board;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardService service = new BoardService();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		String id=null, title=null, contents=null;
		
		String search_id = null;
		
		while(flag) {
			System.out.println("1. Board 등록  2. Board ID 검색  3. 전체 출력  4.ID 검색 후 정보 수정   5. Board 삭제  6.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				
				System.out.println("id 입력: ");
				id = sc.next();
				
				System.out.println("title 입력: ");
				title = sc.next();
				
				System.out.println("contents 입력: ");
				contents = sc.next();
				
				service.BoadInsert(new Board(id, title, contents));
				break;
				
			case 2:
				//search(data);
				System.out.println("검색할 id 입력: ");
				search_id = sc.next();
				
				System.out.println(service.BoardSelect(search_id));
				break;
			case 3:
				//전체 검색
				System.out.println("전체 출력 결과: ");
				service.BoardSelectAll();
				break;
			case 4:
				//수정
				System.out.println("검색할 id 입력: ");
				id = sc.next();
					
				System.out.println("수정할 title 입력: ");
				title = sc.next();
				
				System.out.println("수정할 contents 입력: ");
				contents = sc.next();
				
				Board board = new Board(id,title, contents);
				service.BoardUpdate(board);
				break;
			case 5:
				//삭제
				System.out.println("검색할 id 입력: ");
				search_id = sc.next();
				
				service.BoardDelete(search_id);
				
				break;
	
			case 6:
				//종료
				flag = false;
				break;
			}
		}

	}

}

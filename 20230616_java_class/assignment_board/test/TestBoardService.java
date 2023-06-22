package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

//import exception.DuplicateTelException;
//import exception.PersonNotFoundException;
import service.BoardService;
import vo.*;

public class TestBoardService {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
    {
    	Scanner sc = new Scanner(System.in);
    	String search_Id = null;
    	BoardService service = new BoardService();
		boolean flag = true;
		
		
		
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		
		
		while(flag) {
		System.out.println("1. 등록  2. 검색  3.수정  4.삭제  5. 전체출력  6.종료");
		String menu = br.readLine();
		
			
			switch(menu) {
				//1. 등록
					case "1":
						System.out.println("1. 교직원   2. 학생   3. 선생님");
						int num = sc.nextInt();
						service.insertBoard(num);
						break;
						
					//2. 검색
					case "2":
						System.out.println("검색할 Id 입력: ");
						search_Id = sc.next();
						service.findboard(search_Id);
						break;
						
					//3. 수정	
					case "3":
						System.out.println("수정할 Id 입력: ");
						search_Id = sc.next();
						service.updateboard(service.findboard(search_Id));
						break;
						
					//4. 삭제
					case "4":
						System.out.println("삭제할 Id	 입력: ");
						search_Id = sc.next();
						service.deleteboard(search_Id);
						break;
					//5. 전체 출력
					case "5":
						service.saveData("/Users/ihyunju/Desktop/member.obj");
						service.loadData("/Users/ihyunju/Desktop/member.obj");
						break;
						
					case "6": 
						flag = false;
						break;
						
					default:
						System.out.println("메뉴 입력값 오류입니다.  ");
					
				}
			}
    	}
	}
}



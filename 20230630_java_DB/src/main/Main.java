package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import board.Board;
import join.*;
import product.Product;

public class Main {
	
	public static String loginId ="";
	public static String loginPwd="";
	//회원관리
	public static void func1(Scanner sc, join.Service service) {
		//1. 회원가입  2. 내정보수정  3.로그인  4. 로그아웃  5.탈퇴  6.종료
		int menu = 0;
		String id="", pwd="", name="", email="";
		boolean flag = true, loginFlag=false;
		Member member = null;
		String search_id=null;
		
		while(flag) {
			System.out.println("1. 회원가입  2. 내정보수정  3.로그인  4. 로그아웃  5.탈퇴 6.종료");
			String menu_num = sc.next();
			
			switch(menu_num) {
			case "1":
				member = new Member();
				System.out.println("id 입력: ");
				member.setId(sc.next());
				
				System.out.println("pwd 입력: ");
				member.setPwd(sc.next());
				
				System.out.println("name 입력: ");
				member.setName(sc.next());
				
				System.out.println("email 입력: ");
				member.setEmail(sc.next());
				
				service.addMember(member);
				break;
				
			case "2":
				//내 정보 수정
				if(loginId==null || loginId.equals("")) {
					System.out.println("로그인 먼저 하세요.");
				} else {
					member = new Member();
					
					System.out.println("현재 로그인 id는: "+loginId);
					member.setId(loginId);
					
					System.out.println("new _pwd::");
					member.setPwd(sc.next());
					
					System.out.println("new _name::");
					member.setName(sc.next());
					
					System.out.println("new _email::");
					member.setEmail(sc.next());
					
					service.editMemberInfo(member);
				}
				
				break;
			case "3":
				//로그인
				if(loginId==null || loginId.equals("")) {
					System.out.println("id 입력:: ");
					search_id = sc.next();
					
					System.out.println("pwd 입력:: ");
					pwd = sc.next();
					
					if (service.login(search_id, pwd)) {
						loginId = search_id;
						loginPwd = pwd;
					}
				} else {
					System.out.println("이미 로그인 상태입니다. "+loginId);
				}
				
				break;
			case "4":
				//로그아웃
				if(loginId==null || loginId.equals("")) {
					System.out.println("로그인 하지 않은 상태입니다.  ");
				} else {
					System.out.println("현재 로그인 id는: "+loginId);
					
					System.out.println("pwd 입력:: ");
					pwd = sc.next();
					
					member = service.getMember(loginId);
					
					if(member.getId() != null) {
						if(!member.getPwd().equals(pwd)) {
							System.out.println("id에 부합하지않은 패스워드입니다. ");
							break;
						}
						System.out.println("로그아웃 성공!");
						loginId = null;
						loginPwd = null;
					} else {
						System.out.println("가입되지않은 회원입니다. ");
					}
				}
				break;
			case "5":
				//탈퇴
				
				if(loginId==null || loginId.equals("")) {
					System.out.println("로그인 하지 않은 상태입니다. ");
				} else {
					System.out.println("현재 로그인 id는: "+loginId);
					System.out.println("pwd 입력:: ");
					pwd = sc.next();
					member= service.getMember(loginId);
					if(pwd.equals(member.getPwd())) {
						System.out.println("탈퇴 완료하였습니다. ");
						service.removeMember(search_id);
					} else if(member.getId() == null) {
						System.out.println("존재하지않은 회원입니다. ");
					} else {
						System.out.println("탈퇴 오류입니다. ");
					}
				}
				
				break;
	
			case "6":
				//종료
				flag = false;
				break;
			default:
				System.out.println("입력값 오류입니다. ");
			}
		}
	}
	
	//게시판 관리
	public static void func2(Scanner sc, board.Service service) {
		//1.글쓰기 2. 글번호로 검색  3.글수정  4.글 삭제  5.전체글보기 6.종료")
				int menu = 0;
				String writer=null, pwd=null, title=null, content=null;
				boolean flag = true, loginFlag=false;
				Board board = null;
				String search_id=null;
				
				while(flag) {
					System.out.println("1.글쓰기 2. 글번호로 검색  3.글수정  4.글 삭제  5.전체글보기 6.종료");
					String menu_num = sc.next();
					
					switch(menu_num) {
					case "1": //글쓰기
						
						if(loginId==null || loginId.equals("")) {
							System.out.println("로그인 먼저 해주세요: ");
						} else {
							board = new Board();
							board.setWriter(loginId);
							board.setPwd(loginPwd);
							
							System.out.println("title 입력: ");
							board.setTitle(sc.next());
							
							System.out.println("content 입력: ");
							board.setContent(sc.next());
							
							service.write(board, loginId);
						}
					
						break;
						
					case "2":
						//글 번호 검색
						if(loginId==null || loginId.equals("")) {
							System.out.println("로그인 먼저 하세요.");
						} else {
							System.out.println("검색할 숫자 입력: ");
							int num = sc.nextInt();
							board = service.getArticle(num);
							if (board.getPwd() != null) {
								System.out.println("검색 결과: "+board);
							} else {
								System.out.println("해당 검색 결과가 없습니다. ");
							}
			
						}
						
						break;
					case "3":
						//글 수정
						if(loginId==null || loginId.equals("")) {
							System.out.println("로그인 먼저 하세요.");
						} else {
							System.out.println("검색할 숫자 입력: ");
							int num = sc.nextInt();
							board = service.getArticle(num);
							
							if (board.getPwd() != null) {
								service.editArticle(board);
							} else {
								System.out.println("해당 검색 결과가 없습니다. ");
							}
			
						}
						
						break;
					case "4":
						//글 삭제
						if(loginId==null || loginId.equals("")) {
							System.out.println("로그인 하지 않은 상태입니다.  ");
						} else {
							System.out.println("검색할 숫자 입력: ");
							int num = sc.nextInt();
							board = service.getArticle(num);
							if (board.getPwd() != null) {
								service.delArticle(num);
							} else {
								System.out.println("해당 검색 결과가 없습니다. ");
							}
						}
						break;
					case "5":
						//전체 글보기, 로그인 없어도 가능
						service.getArticles();
						break;
			
					case "6":
						//종료
						flag = false;
						break;
					default:
						System.out.println("입력값 오류입니다. ");
					}
				}
	}


	public static void func3(Scanner sc, product.Service service) {
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		join.Service j_service = new join.ServiceImpl();
		board.Service b_service = new board.ServiceImpl();
		//func1(sc, j_service);
		//func2(sc, b_service);
		
		boolean total_flag = true;
		
		while(total_flag) { // 1.회원관리  2.게시판
			System.out.println("실행할 메뉴 숫자 입력: 1. 회원관리  2.게시판  3.종료");
			String total_num = sc.next();
			
			switch(total_num) {
			case "1":
				func1(sc, j_service);
				break;
			case "2":
				func2(sc, b_service);
				break;
			case "3":
				total_flag = false;
				break;
			default:
				System.out.println("입력 값 오류입니다. ");
			}
		}
		
		
	}
	

}



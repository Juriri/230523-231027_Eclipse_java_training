package step4;

import java.util.Scanner;

public class AddrMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addr[] ad = new Addr[2];
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menu;
		
		while(flag) {
			System.out.println("1. 등록 ");
			System.out.println("2. 출력 ");
			System.out.println("3. 검색 ");
			System.out.println("4. 수정 ");
			System.out.println("5. 종료 ");
			
			menu = sc.nextInt();
	
			switch(menu) {
			case 1://등록
				for(int i=0; i<ad.length; i++) {
					ad[i] = new Addr();
					System.out.println(ad.length+"중 "+(i+1)+"번째 사람 정 입력: ");
					ad[i].register();
				}
				break;
			case 2://출력
				for(int i=0; i<ad.length; i++)
					ad[i].print();
				break;
			case 3://검색
				System.out.println("찾을 사람의 이름을 입력하세요: ");
				String str2 = sc.next();
				for(int i=0; i<ad.length; i++) {
					if(ad[i].search(str2)) {
						System.out.println("해당 이름의 사용자 정보 검색 완료: "+"name:"+ad[i].name+", tel: "+ad[i].tel+",address: "+ad[i].addr);
						break;
					}
				
					else if(i == ad.length-1 && ad[i].search(str2)==false)
						System.out.println("검색 결과 없습니다. ");
				}
				break;
			case 4://수정
				System.out.println("수정할 사람의 이름을 입력하세요: ");
				str2 = sc.next();
				for(int i=0; i<ad.length; i++) {
					if(ad[i].search(str2)) {
						System.out.println("해당 이름의 수정할 이름을 입력하세요: ");
						ad[i].name = sc.next();
						System.out.println("해당 이름의 수정할 전화번호를 입력하세요: ");
						ad[i].tel = sc.next();
						break;
					}
					else if(i == ad.length-1 && ad[i].search(str2)==false)
						System.out.println("검색 결과 없습니다. ");
				}
				break;
			case 5://종료
				flag = false;
					
			}
		}
	}

}

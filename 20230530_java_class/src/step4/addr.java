package step4;
import java.util.Scanner;

public class addr {
//이름, 전화번호,주소	
	String name, phone, address;
	
	public void get_Info() {
		addr[] ad = new addr[3];
		boolean flag  = true;
		Scanner sc = new Scanner(System.in);
		int menu, count=0;
		
		while(flag) {
			System.out.println("1.등록  2.출력  3.종료 ");
			menu = sc.nextInt();
			
			if(menu == 3) {
				flag  = false;
			}
			else {
				if (menu == 1) {
					ad[count] = new addr();
					System.out.println("이름을 입력하세요: ");
					ad[count].name = sc.next();
					System.out.println("주소 입력하세요: ");
					ad[count].address = sc.next();
					System.out.println("전화번호를 입력하세요: ");
					ad[count].phone = sc.next();
					count++;
					
//					for(int i=0; i<ad.length; i++) {
//						ad[i] = new addr();
//						System.out.println("이름을 입력하세요: ");
//						ad[i].name = sc.next();
//						System.out.println("주소 입력하세요: ");
//						ad[i].address = sc.next();
//						System.out.println("전화번호를 입력하세요: ");
//						ad[i].phone = sc.next();
//					}
				}
				else {
					for(int i=0; i<ad.length; i++) {
						System.out.println((i+1)+". "+"이름:"+ad[i].name+" 주소:" + ad[i].address +" 전화번호:"+ ad[i].phone+"\n");
					}
				}
			}
		}
		
	}

}

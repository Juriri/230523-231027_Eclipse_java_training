package step4;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int monster_num, menu_num;
		
		boolean flag = true;
		
		System.out.println("종족을 선택하세요: 1.피카츄  2. Lee  3. 꼬북이");
		monster_num = sc.nextInt();
		System.out.println("이름: ");
		String name = sc.next();
		Overr monster = null;
		
		if(monster_num == 1) {
			monster = new Pikachu(name);
		} else {
			if(monster_num ==2 ) {
				monster = new Lee(name);
			}else {
				monster = new Gobbuk(name);
			}
		}
		while(flag) {
			System.out.println("1. 밥먹기 2. 잠자기 3. 운동하기 4. 공격 5. 종료 ");
			menu_num = sc.nextInt();
			
			switch(menu_num) {
			
			case 1:
				monster.eat();
				break;
			case 2:
				monster.sleep();
				break;
			case 3:
				monster.exercise();
				break;
			case 4:
				monster.attack();
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}

}

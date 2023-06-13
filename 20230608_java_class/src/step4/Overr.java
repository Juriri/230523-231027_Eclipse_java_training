package step4;

import java.util.Scanner;

//몬스터 키우기
//1. 밥먹기 2. 잠자기 3. 운동하기 4. 공격 5. 종료
//eat(), sleep(), exercise(), attack(), aging(), print()

public abstract class Overr {
	protected String name, race;
	protected int age, power,energy;
	
	
	public void print() {
		System.out.println("현재 상태: age "+age+" power "+power+" energy "+energy);
	}
	
	public abstract void eat();
	public abstract void sleep();
	public abstract void exercise();
	public abstract void attack();
	public void aging() {
		if(energy >= 10) {
			age += 1;
			energy = 0;
			System.out.println("레벨업 : "+age);
		}
	}
}

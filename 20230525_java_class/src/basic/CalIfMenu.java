package basic;

import java.util.Scanner;

public class CalIfMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				boolean flag = true;
				int num1=0, num2=0;
				int menu_num= 0, result=0;

				Scanner sc = new Scanner(System.in);
				
				while(flag) {
					System.out.print("1.더하기 ");
					System.out.print("2.빼기 ");
					System.out.print("3.곱하기 ");
					System.out.print("4.나누기 ");
					System.out.print("5.종료\n");
					
					menu_num = sc.nextInt();
					
					
				if(menu_num==1) {
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1+num2;	
						System.out.println("결과 값: "+num1+"+"+num2+"="+result+"\n");
				}
				else if(menu_num==2) {
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1-num2;	
						System.out.println("결과 값: "+num1+"-"+num2+"="+result+"\n");
				}
						
				else if(menu_num==3) {
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1*num2;	
						System.out.println("결과 값: "+num1+"*"+num2+"="+result+"\n");
				}
						
				else if(menu_num==4) {
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						//나눗셈 소수점 출력
						float temp_result=0;
						temp_result = (float)num1/num2;	
						System.out.println("결과 값: "+num1+"/"+num2+"="+temp_result+"\n");
				}
						
				else if(menu_num==5) {
						System.out.println("종료합니다.");
						flag = false;	
					}
				}
				sc.close();
			}
}

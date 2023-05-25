package basic;

import java.util.Scanner;

public class CalSwitchMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				boolean flag = true;
				int num1=0, num2=0;
				int menu_num= 0, result=0;
				String op = "";
				Scanner sc = new Scanner(System.in);
				
				while(flag) {
					System.out.print("1.더하기");
					System.out.print("2.빼기");
					System.out.print("3.곱하기");
					System.out.print("4.나누기");
					System.out.print("5.종료\n");
					
					menu_num = sc.nextInt();
					
					
					switch(menu_num) {
						case 1:
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1+num2;	
						op = "+";
						System.out.println("결과 값: "+num1+op+num2+"="+result);
						break;
					case 2:
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1-num2;	
						op = "-";
						System.out.println("결과 값: "+num1+op+num2+"="+result);
						break;
					case 3:
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						
						result = num1*num2;	
						op = "*";
						System.out.println("결과 값: "+num1+op+num2+"="+result);
						break;
					case 4:
						System.out.println("첫 번째 숫자를 입력하세요 : ");
						num1 = sc.nextInt();
						
						System.out.println("두 번째 숫자를 입력하세요 : ");
						num2 = sc.nextInt();
						float temp_result=0;
						
						temp_result = (float)num1/num2;	
						op = "/";
						System.out.println("결과 값: "+num1+op+num2+"="+temp_result);
						break;
					case 5:
						System.out.println("종료합니다.");
						flag = false;	
					}
				}
				sc.close();
			}
}

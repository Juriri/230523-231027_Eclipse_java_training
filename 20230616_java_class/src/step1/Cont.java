package step1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Cont {
	
	public String date;
	
	public void write() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> v = new ArrayList<>();
		
		
		Calendar c = Calendar.getInstance();
		
		FileWriter fos = null;
		System.out.println("1. 오늘  2. 지난날");
		int a = sc.nextInt();
		int y=0, m=0, dd=0;
		
		if(a==1) {
			y=c.get(Calendar.YEAR);
			m=c.get(Calendar.MONTH+1);
			dd=c.get(Calendar.DATE);
		
		date=y+"년도"+m+"월"+"일"; 
		System.out.println(date);
		}else {
			System.out.println("날짜를 입력하세요; 예)0년0월0일");
			date = sc.next();
		}
		v.add(date); 
		System.out.println("내용: ");
		
		while(true) {
			String x = null;
			x = sc.next();
			
			if(x.equals("끝")) {
				break;}
			v.add(x);
			
			File f = new File("MyDiary"); //MyDiary 에 대한 파일 객체 생성
			if(!f.exists()) {
				f.mkdir();
				
				try {
					fos=new FileWriter("././MyDiary");
					for(int i=0; i<v.size(); i++) {
						fos.write("/n");
						fos.write(v.get(i));
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			}
			
		}
	}
	
	public void read() {
		
	}
	
	
}

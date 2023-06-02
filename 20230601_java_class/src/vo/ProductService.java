package vo;

import java.util.Scanner;

public class ProductService {
	
	private Product[] p= new Product[3];
	private int index = 0;
	private String name, co, company, cus;
	Scanner sc = new Scanner(System.in);
	
	public void addPerson(Product p) {
		this.p[index] = p;
		index++;

	}
	
	public void printAll() {
		for(int i=0; i<index; i++) {
			//System.out.println(ad[i]);
			System.out.print("name: "+p[i].getName()+" ");
			System.out.print("co: "+p[i].getCo()+" ");
			System.out.print("company: "+p[i].getCompany()+"");
			System.out.print("cus: "+p[i].getCus()+"");
			System.out.println("");
		}
	}
	
	public Product findPerson(String find_name) {
		
		Product per = null;
		for(int i=0; i<index; i++) {
			if( p[i].getName().equals(find_name)) {
				per = p[i];
			}
			
			else if(index == i && p[i].getName().equals(find_name) == false) {
				System.out.println("결과를 찾을 수 없습니다. ");
			}
		}
		
		System.out.println("검색 결과: name "+per.getName()+" co: "+per.getCo()+" company: "+per.getCompany()+"Cus: "+per.getCus());
		return per;
	}
	
	public void editPerson(String find_name) {
		
		Product per = findPerson(find_name);
		System.out.println("수정할 회사 제조사 입력: ");
		co = sc.next();
		System.out.println("수정할 회사명 입력: ");
		company = sc.next();
		System.out.println("수정할 거래처 입력: ");
		cus = sc.next();
		
		per.setCo(co);
		per.setCompany(company);
		per.setCus(cus);
		
		System.out.println("수정 결과: name "+per.getName()+" 거래처: "+per.getCo()+" 회사명: "+per.getCompany());
	}
}
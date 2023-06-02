package vo;

import java.util.Scanner;

import vo.address;

public class AddressService {
	private address[] ad= new address[3];
	private int index = 0;
	private String name=null, tel=null, address=null;
	Scanner sc = new Scanner(System.in);
	
	public void addPerson(address a) {
		this.ad[index] = a;
		index++;

	}
	
	public void printAll() {
		for(int i=0; i<index; i++) {
			//System.out.println(ad[i]);
			System.out.print("name: "+ad[i].getName()+" ");
			System.out.print("tel: "+ad[i].getTel()+" ");
			System.out.print("address: "+ad[i].getAddress()+"");
			System.out.println("");
		}
	}
	
	public address findPerson(String find_name) {
		
		address per = null;
		for(int i=0; i<index; i++) {
			if( ad[i].getName().equals(find_name)) {
				per = ad[i];
			}
			
			else if(index == i && ad[i].getName().equals(find_name) == false) {
				System.out.println("결과를 찾을 수 없습니다. ");
			}
		}
		
		System.out.println("검색 결과: name "+per.getName()+" 전화번호: "+per.getTel()+" 주소: "+per.getAddress());
		return per;
	}
	
	public void editPerson(String find_name) {
		
		address per = findPerson(find_name);
		System.out.println("수정할 전화번호 입력: ");
		tel = sc.next();
		System.out.println("수정할 주소 입력: ");
		address = sc.next();
		
		per.setTel(tel);
		per.setAddress(address);
		
		System.out.println("수정 결과: name "+per.getName()+" 전화번호: "+per.getTel()+" 주소: "+per.getAddress());
	}
}

package step4;

import java.util.ArrayList;
public class Professor extends Person{

	private ArrayList<String> sub_arr = new ArrayList<>();
	
	public void print_subject() {
		System.out.println("이름:  "+name+"의 수업 과목은 "+sub_arr);
	}

	public ArrayList<String> getSubject() {
		return sub_arr;
	}

	public void setSubject(String str) {
		sub_arr.add(str);
	}
}

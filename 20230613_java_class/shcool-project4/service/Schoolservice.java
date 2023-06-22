package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vo.*;
import exception.*;

public class Schoolservice {
	
	//학교 구성원을 추가하는 메서드
	//동일한 번호의 구성원이 추가되려고 하면 DuplicateTelException을 발생(throw) 시키고 throws한다.
	private List<Person> list = new ArrayList<>();
	//throw(Exception 보내온 메세지), throws(메서드에 예외 발생 시 JVM에 위치 알려줌)
	//동일한 번호를 추가할 수 없다.
	
	//등록
	public void addMember(Person p) throws DuplicateTelException {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTel().equals(p.getTel())) {
				throw new DuplicateTelException("동일한 전화번호가 존재하여 추가할 수가 없습니다. ");
				
			}
		}
		list.add(p);
		
	}


	//전체출력
	public void printAll(){
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	//검색
	public Person findMemberVO(String tel) throws PersonNotFoundException {
		
		System.out.println(tel+" 전화번호를 검색합니다. ");
		Person p = null;
		
		for(int i=0; i<list.size(); i++) {
			Person compare = list.get(i);
			if(compare.getTel().equals(tel))  {
				p = list.get(i);
			}
		}
		if(p == null)
			throw new PersonNotFoundException("해당 사람 검색 결과 없습니다. ");
		else
			return p;
	}
	
	//삭제
	public void deleteMember(String tel) throws PersonNotFoundException {
		
		System.out.println(tel+" 전화번호인 사람의 정보를 삭제합니다. ");
		int index = -1;
		
		for(int i=0; i<list.size(); i++) {
			Person compare = list.get(i);
			if(compare.getTel().equals(tel))  {
				index = i;
			}
		}
		if(index == -1)
			throw new PersonNotFoundException("해당 사람 검색 결과 없습니다. ");
		else
			list.remove(index);
	}
	
	//수정
	public void updateMember(String search_tel, Person p){
		Scanner sc = new Scanner(System.in);
		String tel=null, name=null;
		
		System.out.println(search_tel+" 전화번호 사람의 정보를 수정합니다. ");
		

		System.out.println("수정할 이름 입력: ");
		name = sc.next();
		p.setName(name);
		
		System.out.println("수정할 전화번호 입력: ");
		tel = sc.next();
		p.setTel(tel);
		
		
	}	
}

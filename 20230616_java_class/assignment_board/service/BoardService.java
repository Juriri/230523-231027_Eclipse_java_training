package service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.EmpMember;
import vo.Member;
import vo.StuMember;
import vo.TeachMember;



public class BoardService {

	private ArrayList<Member> list = new ArrayList<>();
	
	InputStream is = System.in;
	InputStreamReader ir = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(ir);

	public void loadData(String fileName) throws IOException, ClassNotFoundException {
		
		try{
			ArrayList<Member> temp_list = new ArrayList<>();
			
			System.out.println("데이터가 로딩되었습니다.");
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			temp_list =(ArrayList) ois.readObject();
			
			for(int i=0; i<temp_list.size(); i++) {
				System.out.println(temp_list.get(i));
			}
			
			ois.close();
			
		} catch(FileNotFoundException e){
			System.out.println("저장된 데이터가 없습니다.");
		}
		
	}
	
	
	// throw, throws
	public void saveData(String fileName) throws IOException{
		FileOutputStream fos=new FileOutputStream(fileName);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.close();		

	}
	

	public void insertBoard(int menu) throws IOException {
				
		
		String Id=null, Contents=null, dept=null, subject=null;
		int stuId;
		
		Member mem = null;
		System.out.println("Id를 입력하세요: ");
		Id = br.readLine();
		System.out.println("Contents를 입력하세요: ");
		Contents = br.readLine();
		
		for(int i=0; i<list.size(); i++) {
			Member temp_obj = (Member) list.get(i);
			if(temp_obj.getId().equals(Id)) {
				System.out.println("동일한 Id가 존재하여 추가할 수가 없습니다. ");
				return;
			}
		}
		
		try {
			
			//1. 교직원  2. 학생  3. 선생님
			if(menu==1) {
				System.out.println("dept 입력: ");
				dept = br.readLine();
				System.out.println("id"+ Id+" Conte: "+Contents);
				mem  = new EmpMember(Id, Contents, dept);
				list.add(mem);
			} else {
				if(menu==2) {
					System.out.println("stuId 입력: ");
					stuId = Integer.parseInt(br.readLine());
					mem = new StuMember(Id, Contents, stuId);
					list.add(mem);
				
				} else if (menu==3) {
					System.out.println("subject 입력: ");
					subject = br.readLine();
					mem = new TeachMember(Id, Contents, subject);
					list.add((Member) mem);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
		    e.printStackTrace();
		}
	}
		
	
	

	public Member findboard(String id) {
		int index = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				System.out.println(list.get(i));
				return list.get(i);
				
			}
		}
		
		if (index == -1) {
			System.out.println("검색 결과 없습니다. ");
		}
		
		return null;
	}

	public void deleteboard(String id) {
		if(findboard(id) == null) {
			return ;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)){
				System.out.println("id: "+id+" 삭제 완료 ");
				list.remove(i);
			}
		}
			
		
	}

	public void updateboard(Member productVO) throws IOException{
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).equals(productVO)) {
					System.out.println("수정할 정보의 Id 입력: ");
					String new_id = br.readLine();
					System.out.println("수정할 정보의 Contents 입력: ");
					String new_con = br.readLine();
					
					list.get(i).setId(new_id);
					list.get(i).setContents(new_con);
					
					System.out.println("수정완료: "+list.get(i));
				
			}
		}
	}

}

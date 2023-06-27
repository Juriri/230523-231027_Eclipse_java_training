package service;

import java.util.List;

import vo.member;

public class MemberService implements Service{
	
	private Dao dao;
	
	public MemberService() {
		
		dao = new MemberDAO();
	}

	@Override
	public void addMember(member mem) {
		// TODO Auto-generated method stub
		dao.insertMember(mem);
		
	}

	@Override
	public member getMember(String id) {
		// TODO Auto-generated method stub
		
		return dao.selectMember(id);
	}

	@Override
	public List<member> print(int type) {
		return dao.Allselect(type);
	}
	@Override
	public void editMember(member mem) {
		// TODO Auto-generated method stub
		dao.update(mem);
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	

}

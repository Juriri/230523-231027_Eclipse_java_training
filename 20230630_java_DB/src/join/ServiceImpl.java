package join;

public class ServiceImpl implements Service {
	private Dao dao = new DaoOracleImpl();

	@Override
	public boolean addMember(Member m) {
		// TODO Auto-generated method stub
		if(dao.memberInfo(m.getId()).getId() !=null) {
			System.out.println("이미 가입된 아이디입니다. ");
			return false;
		}
		
		int line = dao.insertMember(m);
		
		if(line <= 0) {
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean editMemberInfo(Member member) {
		// TODO Auto-generated method stub
		
		try {
			
			int line = dao.updateMember(member);

			return line <=0 ? false: true;
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean removeMember(String id) {
		// TODO Auto-generated method stub
		Member member = dao.memberInfo(id);
		
		if(member != null) {
			int line = dao.removeMember(id);
			if(line <= 0) {
				System.out.println("회원 정보 삭제 불가");
				return false;
			} else {
				System.out.println("로그아웃 실행되었습니다. ");
				return true;
			}
		}

		System.out.println("없는 회원 정보입니다. ");
		return false;
		
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		if(dao.login(id, pwd) == true) {
			
			System.out.println("'"+id+"'"+"님 login 성공");
			return true;
		} else {
			System.out.println("login 실패");
			return false;
		}
		
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		Member member = dao.memberInfo(id);
		if(member != null) {
			
			return dao.memberInfo(id);
		}
		System.out.println("해당 검색 결과가 없습니다. ");
		return null;
	}

}

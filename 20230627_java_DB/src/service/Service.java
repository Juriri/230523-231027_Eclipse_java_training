package service;

import java.util.List;

import vo.*;

public interface Service {
	
	void addMember(member mem);
	member getMember(String id);
	List<member> print(int type);
	void editMember(member mem);
	void deleteMember(String id);

}

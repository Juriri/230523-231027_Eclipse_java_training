package service;

import java.util.List;

import vo.*;

public interface Dao {

	void con();
	void discon();
	void insertMember(member mem);
	
	member selectMember(String id);
	List<member> Allselect(int type);
	
	void update(member mem);
	void delete(String id);
}

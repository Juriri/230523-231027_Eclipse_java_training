package model;

import java.util.ArrayList;

public interface Dao {
	boolean con();
	void discon();
	void insert(Member m);
	ArrayList<Member> getAll();
	Member getMember(int num);
	void update(Member m);
	void delete(int num);
	Member signin(String search_id, String search_pwd);
}

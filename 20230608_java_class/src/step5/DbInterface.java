package step5;

public interface DbInterface {
	void connect();
	void select();
	void insert();
	void update();
	void delete();
	//daoImpl dao부터 상속을 받아서 구현하는 클래스
}

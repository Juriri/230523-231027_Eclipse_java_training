package step5;

public class OracleImpl implements DbInterface{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 연결");
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 데이터 조회");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 데이터 생성");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 데이터 수정");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Oracle 데이터 삭제");
	}

}

package step5;

public class MsImpl implements DbInterface{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("MSQL 연결");
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("MSQL 데이터 조회");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("MSQL 데이터 생성");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("MSQL 데이터 수정");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("MSQL 데이터 삭제");
	}

}

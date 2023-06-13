package step5;

public class Process implements DbInterface{
	DbInterface db;
	
	public Process(DbInterface db) {
		this.db = db;
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		db.connect();
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		db.select();
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		db.insert();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		db.update();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		db.delete();
	}
	
	
}

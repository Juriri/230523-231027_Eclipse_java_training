package step11;

public class TestHashB {

	public static void main(String[] args) {
		Engineer engin = new Engineer("honda",new Notebook());
		System.out.println("note book의 model과 가격: "+engin.getNotebook().getModel()+" "+engin.getNotebook().getPrice());
		
		//notebook의 모델과 가격을 변경
		engin.getNotebook().setModel("real");
		engin.getNotebook().setPrice(1000);
		System.out.println("note book의 model과 가격 변경 후 "+engin.getNotebook().getModel()+" "+engin.getNotebook().getPrice());
	}

}

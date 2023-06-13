package vo;

public class Employee extends Person{
	
		private int dept;
		
		public Employee(String name, String tel, String address, int dept) {
			super(name, tel, address);
			this.dept = dept;
		}
		
		
		public int getDept() {
			return dept;
		}


		public void setDept(int dept) {
			this.dept = dept;
		}


		
		public void addPerson(Employee em) {
			em.setDept(dept);
		}


		@Override
		public String toString() {
			return super.toString() + "dept: "+dept;
		}
		
		

}

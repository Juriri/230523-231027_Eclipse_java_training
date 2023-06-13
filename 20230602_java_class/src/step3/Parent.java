package step3;

public class Parent {

		public String name;
		protected int age;
		private int money;
		
	
		public void printParentInfo() {
			System.out.println("Parent name: "+name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}
		
		
}

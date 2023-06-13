package step7;

import java.util.List;

public class FriendVO {

		private String name;
		private int age;
		
		public FriendVO(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		

		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "FriendVO [name=" + name + ", age=" + age + "]";
		}
		
		
}

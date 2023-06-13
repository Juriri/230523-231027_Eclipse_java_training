package step7;

public class Engineer extends Employee{
	private String skill;
	private int bonus;
	
	public Engineer(String empId, String name, String address, int salary, String skill, int bonus ) {
		super(empId, name, address, salary);
		this.skill = skill;
		this.bonus = bonus;
	}

	public String getSkill() {
		return skill;
	}

	public int getBonus() {
		return bonus;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
//		return "Engineer [skill=" + skill + ", bonus=" + bonus + ", getEmpId()=" + getEmpId() + ", getName()="
//				+ getName() + ", getAddress()=" + getAddress() + ", getSalary()=" + getSalary() + ", toString()="
//				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
		return super.toString()+"skill "+skill+", bonus"+bonus;
	}

	
}

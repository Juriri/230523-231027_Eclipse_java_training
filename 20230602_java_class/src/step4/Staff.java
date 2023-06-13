package step4;

public class Staff extends Person{
	
	private String job;
	
	public void print_job() {
		System.out.println("이름:  "+name+"의 직업은 "+job);
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}

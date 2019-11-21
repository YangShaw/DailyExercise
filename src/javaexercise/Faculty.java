package javaexercise;

public class Faculty extends Employee{

	private String level;
	private int workingHours;
	public Faculty() {
		super();
	}
	public Faculty(String name, String addr, String phone, String email, String office, double wages,
			MyDate employedDate, String level, int workingHours) {
		super(name, addr, phone, email, office, wages, employedDate);
		// TODO Auto-generated constructor stub
		this.level = level;
		this.workingHours = workingHours;
	}
	
	
	@Override
	public String toString() {
		return "Faculty [name=" + this.getName() + "]";
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	
	
	
	
}

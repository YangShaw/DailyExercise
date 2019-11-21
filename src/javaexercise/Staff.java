package javaexercise;

public class Staff extends Employee {
	
	private String title;
	public Staff() {
		super();
	}
	
	public Staff(String name, String addr, String phone, String email, String office, double wages, 
			MyDate employedDate, String title) {
		super(name, addr, phone, email, office, wages, employedDate);
		// TODO Auto-generated constructor stub
		this.title = title;
	}

	
	@Override
	public String toString() {
		return "Staff [name=" + this.getName() + "]";
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}

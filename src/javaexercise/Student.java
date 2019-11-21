package javaexercise;

public class Student extends Person {

	private final String grade;
	public Student(String grade) {
		super();
		this.grade = grade;
	}
	
	public Student(String name, String addr, String phone, String email, String grade) {
		super(name, addr, phone, email);
		// TODO Auto-generated constructor stub
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [Name=" + this.getName() + "]";
	}
	

	
}

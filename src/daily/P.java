package daily;

class GraduateStudent extends Student {
}

class Student extends Person {
	public String toString() {
		return "Student";
	}
}

class Person extends Object {
	public String toString() {
		return "Person";
	}
}

public class P {

	public static void main(String[] args) {
		m(new GraduateStudent()); // 绑定到它的直接父类
		m(new Student());
		m(new Person());
		m(new Object());
	}

	public static void m(Object x) {

		System.out.println(x.toString());
	}
}

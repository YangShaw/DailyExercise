package javaexercise;

import java.util.*;

public class exercise_11_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	创建person对象
		Person person1 = new Person("p1name","p1addr","p1phone","p1email");
		//	相较person，补充grade的初始化值
		Student student1 = new Student("s1name", "s1addr", "s1phone", "s1email", "1");
		//	相较person，补充办公室、工资、受聘日期的初始化值。这里用当前日期为受聘日期
		Employee employee1 = new Employee("e1name", "e1addr", "e1phone", "e1email",
				"e1office", 10000.0, new MyDate());
		//	相较employee，补充级别和办公时间的初始化值。
		Faculty faculty1 = new Faculty("f1name", "f1addr", "f1phone", "f1email", "f1office",
				15000.0,  new MyDate(), "f1level", 8);
		//	相较employee，补充职位称号的初始化值
		Staff staff1 = new Staff("st1name", "st1addr", "st1phone", "st1email", "st1office", 
				120000.0, new MyDate(), "st1title");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(student1);
		persons.add(employee1);
		persons.add(faculty1);
		persons.add(staff1);
		
		for(Person p : persons) {
			System.out.println(p);
			System.out.println(p.getAddr());
			System.out.println();
		}
		
		
	}

}

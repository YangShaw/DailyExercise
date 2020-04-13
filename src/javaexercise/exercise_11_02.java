package javaexercise;

import java.util.*;

public class exercise_11_02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //	����person����
        Person person1 = new Person("p1name", "p1addr", "p1phone", "p1email");
        //	���person������grade�ĳ�ʼ��ֵ
        Student student1 = new Student("s1name", "s1addr", "s1phone", "s1email", "1");
        //	���person������칫�ҡ����ʡ���Ƹ���ڵĳ�ʼ��ֵ�������õ�ǰ����Ϊ��Ƹ����
        Employee employee1 = new Employee("e1name", "e1addr", "e1phone", "e1email",
                "e1office", 10000.0, new MyDate());
        //	���employee�����伶��Ͱ칫ʱ��ĳ�ʼ��ֵ��
        Faculty faculty1 = new Faculty("f1name", "f1addr", "f1phone", "f1email", "f1office",
                15000.0, new MyDate(), "f1level", 8);
        //	���employee������ְλ�ƺŵĳ�ʼ��ֵ
        Staff staff1 = new Staff("st1name", "st1addr", "st1phone", "st1email", "st1office",
                120000.0, new MyDate(), "st1title");

        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(student1);
        persons.add(employee1);
        persons.add(faculty1);
        persons.add(staff1);

        for (Person p : persons) {
            System.out.println(p);
            System.out.println(p.getAddr());
            System.out.println();
        }


    }

}

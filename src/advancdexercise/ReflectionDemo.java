package advancdexercise;

import java.lang.reflect.Field;

public class ReflectionDemo {

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    public static void main(String[] args) throws Exception {

        Person p = new Person("Xiao Ming");
        System.out.println(p.getName()); // "Xiao Ming"
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "Xiao Hong");
        System.out.println(p.getName()); // "Xiao Hong"

        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));


        //printClassInfo("".getClass());
        //printClassInfo(Runnable.class);
        //printClassInfo(java.time.Month.class);
        //printClassInfo(String[].class);
        //printClassInfo(int.class);
        //printClassInfo(Integer.class);

        Class cls = String.class;
        String str = "hello world";
        Class cls2 = str.getClass();
        String str2 = (String)cls2.newInstance();

        System.out.println(cls.toString());
        System.out.println(cls2.toString());
        System.out.println(cls==cls2);

        System.out.println(str instanceof String);
    }

    class Student extends Person {
        public int score;
        private int grade;

        Student(String name) {
            super(name);
        }
    }

    static class Person {
        private String name;

        Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

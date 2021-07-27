package advancdexercise.expproxy;

/**
 * @author YangShaw
 * @date 2021/4/9 14:33
 */
public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + " gives money");
    }
}

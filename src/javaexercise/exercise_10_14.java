package javaexercise;

public class exercise_10_14 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MyDate d1 = new MyDate();
        System.out.println("The date of d1 is " + d1);

        MyDate d2 = new MyDate(34355555133101L);
        System.out.println("The date of d2 is " + d2);

        MyDate d3 = new MyDate(2019, 02, 22);
        System.out.println("The date of d3 is " + d3);

        d3.setDate(561555550000L);
        System.out.println("The new date of d3 is " + d3);

    }

}

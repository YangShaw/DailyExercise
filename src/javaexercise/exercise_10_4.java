package javaexercise;

public class exercise_10_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println("The distance between p1 and p2 is " + p1.distance(p2));
        System.out.println("The distance between p1 and p2(using another form of function) is " + p1.distance(10, 30.5));
    }

}

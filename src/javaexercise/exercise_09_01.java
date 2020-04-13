package javaexercise;

public class exercise_09_01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println("Rectangle 1:");
        System.out.println("width = " + r1.getWidth() + "\t" + "height = " + r1.getHeight());
        System.out.println("area = " + r1.getArea() + "\t" + "perimeter = " + r1.getPerimeter());
        System.out.println();
        System.out.println("Rectangle 2:");
        System.out.println("width = " + r2.getWidth() + "\t" + "height = " + r2.getHeight());
        System.out.println("area = " + r2.getArea() + "\t" + "perimeter = " + r2.getPerimeter());
    }

}

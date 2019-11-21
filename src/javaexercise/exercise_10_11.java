package javaexercise;

public class exercise_10_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle2D c1 = new Circle2D(2,2,5.5);
		System.out.println("Area: "+c1.getArea());
		System.out.println("Perimeter: "+c1.getPerimeter());
		System.out.println("c1 contains Point (3,3)? "+c1.contains(3, 3));
		System.out.println("c1 contains Circle (2,4,10.5)? "+c1.contains(new Circle2D(2, 4, 10.5)));
		System.out.println("c1 overlaps Circle (3,5,2.3)? "+c1.overlaps(new Circle2D(3,5,2.3)));
	}

}

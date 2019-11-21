package javaexercise;

public class Circle2D {

	private double x;
	private double y;
	private double radius;
	public Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}
	
	
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	private double distance(double x1, double y1) {
		return Math.sqrt(Math.pow(this.x-x1, 2)+Math.pow(this.y-y1, 2));

	}
	
	public boolean contains(double x1, double y1) {
		return radius>=this.distance(x1, y1);
	}
	
	public boolean contains(Circle2D cir) {
		double x = cir.getX();
		double y = cir.getY();
		return this.contains(x, y)&&(this.distance(x, y)+cir.radius<=this.radius);

	}
	
	public boolean overlaps(Circle2D cir) {
		double dis = this.distance(cir.getX(), cir.getY());
		return (dis<(this.radius+cir.getRadius())&&dis>Math.abs(this.radius-cir.getRadius())) ;
	}


	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}

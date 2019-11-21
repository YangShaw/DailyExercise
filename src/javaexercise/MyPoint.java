package javaexercise;

public class MyPoint {

	private double x;
	private double y;
	
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(MyPoint point) {
		return Math.sqrt(Math.pow(this.x-point.getX(), 2)+Math.pow(this.y-point.getY(), 2));
	}
	
	public double distance(double x1, double y1) {
		return Math.sqrt(Math.pow(this.x-x1, 2)+Math.pow(this.y-y1, 2));
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
	
}

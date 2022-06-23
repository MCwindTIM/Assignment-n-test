package Q2;

import java.awt.Point;

class Circle extends Shape {
	private double radius;
	private Point center;
	
	public Circle (int x, int y, double radius) {
		super("Circle", x, y);
		setRadius(radius);
		setCenter(new Point(x,y));
	}
	public void setRadius(double r) {
		r = (r>=0) ? r :0;
	}
	public double getRadius() {return radius;}
	public void setCenter(Point p) {center = p;}
	public Point getCenter() {return center;}
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public String toString() {
		return "Circle at " + center.toString() + ": Radius = " + radius + ", the perimeter is " + getPerimeter() + " and the area is " + getArea();
	}
}

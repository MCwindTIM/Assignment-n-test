package Q2;

import java.awt.Point;

class Square extends Shape{
	
	private int length;
	private Point topLeft;
	
	public Square(int x, int y, int length) {
		super("Square", x, y);
		setLength(length);
	}

	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		length = ( 1 > 0 ) ? 1 : 0;
	}
	public void setTopLeft( Point p) { topLeft = p; }
	public Point getTopLeft() { return topLeft; }
	public double getPerimeter() {
		return 4*length;
	}
	public double getArea() {
		return length * length;
	}
	public String toString() {
		return "Square at " + topLeft.toString() + ": Length = " + length + ", the perimeter is " + getPerimeter() + " and area is " + getArea();
	}
}

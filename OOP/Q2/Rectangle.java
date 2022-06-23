package Q2;

import java.awt.Point;

class Rectangle extends Shape {
	private int width;
	 private int height;
	 private Point topLeft;
	 
	 public Rectangle(int x, int y, int width, int height) {
		 super("Rectangle", x, y);
		 setTopLeft(new Point(x,y));
		 setWidth(width);
		 setHeight(height);
	 }
	 public void setWidth(int width) {
		 width = (width > 0) ? width :0;
	 }
	 public int getWidth() {return width;}
	 public void setHeight(int height) {
		 height = (height>0) ? height :0;
	 }
	 public int getHeight() {return height;}
	 public void setTopLeft( Point p) {topLeft = p;}
	 public Point getTopLePoint( ) {return topLeft;}
	 public double getPerimeter() {
		 return 2*height + 2*width;
	 }
	public double getArea() { 
		return height * width;
	}
	public String toString() {
		return "Rectangle at " + topLeft.toString() + " : Width = " + width + ", Height = " + height + ", the perimeter is " + getPerimeter() + "and area is " + getArea();
	}
}

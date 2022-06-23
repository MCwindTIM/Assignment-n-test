package Q2;

public abstract class Shape {
	// declare pivate instance variables
	private int x;
	private int y;
	private String name;
	
	public Shape(String name, int x, int y) {
		this.name = name;
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getName() { return name; }
	
	public void setX(int x) {
		if(x>=0)
			this.x = x;
	}
	
	public void setY(int y) {
		if(y>=0)
			this.y = y;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}

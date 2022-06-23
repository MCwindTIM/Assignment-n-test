package tk.duckduckdoc.oomplab4;

public class Circle extends Shape {
    double radius;
    Point center;

    public Circle(double radius, double centerX, double centerY){
        super("Circle");
        setRadius(radius);
        setCenter(centerX, centerY);
    }

    public void setRadius(double r){
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setCenter(double x, double y){
        this.center = new Point(x, y);
    }

    public Point getCenter(){
        return this.center;
    }

    public double getArea(){
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public String toString(){
        return "Center = " + this.center + "; Radius = " + this.radius;
    }

}

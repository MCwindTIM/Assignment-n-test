package tk.duckduckdoc.oomplab4;

public class Rectangle extends Shape {
    Point topLeft;
    double width;
    double height;

    public Rectangle(double x, double y, double w, double h){
        super("Rectangle");
        setTopLeft(x, y);
        setWidth(w);
        setHeight(h);
    }

    public void setTopLeft(double x, double y){
        this.topLeft = new Point(x, y);
    }

    public Point getTopLeft(){
        return this.topLeft;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth(){
        return this.width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public String toString(){
        return "TopLeft = " + this.getTopLeft() + "; Width = " + this.getWidth() + "; Height = " + this.getHeight();
    }
}

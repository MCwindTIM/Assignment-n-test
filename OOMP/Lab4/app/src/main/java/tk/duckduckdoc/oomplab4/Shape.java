package tk.duckduckdoc.oomplab4;

public abstract class Shape {
    protected String Name;
    public Shape( String n ) {
        Name = new String( n );
    }

    public abstract double getArea();
    public String getName() { return Name; }
}

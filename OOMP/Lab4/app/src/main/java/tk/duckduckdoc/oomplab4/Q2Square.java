package tk.duckduckdoc.oomplab4;

public class Q2Square extends Q2Shape {	//line 6
    private int side;	//line 7
    public Q2Square(String name, int side){
        super(name);	//line 8
        this.side = side;	//line 9
    }
    public double area(){
        return side*side;
    }
}

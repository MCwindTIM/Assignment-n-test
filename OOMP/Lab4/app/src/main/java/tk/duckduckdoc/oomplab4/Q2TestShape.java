package tk.duckduckdoc.oomplab4;

public class Q2TestShape {
    public void main(String[] args){	//line 14
        Q2Shape s1 = new Q2Square("Square1", 4);	//line 15
        Q2Shape s2 = new Q2Circle("Circle1", 2);	//line 16
        System.out.println("Area of circle: " + s2.area());
        //line 17
        System.out.println("Area of square: " + s1.area());
        //line 18
    }
}

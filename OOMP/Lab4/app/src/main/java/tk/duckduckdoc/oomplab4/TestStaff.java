package tk.duckduckdoc.oomplab4;

public class TestStaff {
    public static void main(String args[]) {
        ParttimeStaff p1 = new ParttimeStaff("John", 123, 'B', 20);
        ParttimeStaff p2 = new ParttimeStaff("Mary", 124, 'A', 22);
        p1.display();
        p2.display();
    }
}
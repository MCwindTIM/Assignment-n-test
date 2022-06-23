package tk.duckduckdoc.oomplab3;


public class TestEmp {
    public static void main(String s[]) {
        Employee employee = new Employee("John", 31520);
        FTEmployee ft = new FTEmployee("Mary", 71600, 15000.0);

        System.out.println(employee);
        System.out.println(ft);
    }
}
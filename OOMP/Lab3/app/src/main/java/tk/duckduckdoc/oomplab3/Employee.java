package tk.duckduckdoc.oomplab3;

public class Employee {
    // A “static” variable is shared by all objects of
    //    the class.
    // A “final” variable can be set only ONCE and
    //    cannot be changed later.
    public static final int MIN_ID = 10000;

    // A “protected” can be used directly in subclasses.
    protected String name;
    protected int employeeID;

    public Employee(String n, int id) {
        name = n;
        if (id < MIN_ID)
            employeeID = 0;
        else
            employeeID = id;
    }

    public String toString() {
        return "Name : " + name
                + ", EmployeeID : " + employeeID;
    }
}

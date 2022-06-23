package tk.duckduckdoc.oomplab3;

public class FTEmployee extends Employee {
    protected  double salary;

    public FTEmployee(String name, int employeeID, double salary){
            super(name, employeeID);
            this.salary = salary;
    }

    public String toString(){
        return "Name : " + this.name + ", EmployeeID : " + this.employeeID + ", Salary : " + this.salary;
    }
}

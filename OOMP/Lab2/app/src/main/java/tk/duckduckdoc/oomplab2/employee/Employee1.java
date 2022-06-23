package tk.duckduckdoc.oomplab2.employee;

public class Employee1 {
    private String name;
    private int salary;

    public Employee1(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }
}

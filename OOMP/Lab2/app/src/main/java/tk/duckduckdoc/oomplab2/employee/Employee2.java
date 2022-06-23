package tk.duckduckdoc.oomplab2.employee;

class Employee2 {
    private String name;
    private int salary;

    //Q4(a)
    public Employee2(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public void raiseSalary(double salary){
        this.salary *= salary;
    }
}

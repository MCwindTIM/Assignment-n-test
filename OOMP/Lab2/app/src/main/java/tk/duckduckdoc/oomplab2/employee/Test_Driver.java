package tk.duckduckdoc.oomplab2.employee;

public class Test_Driver {
    public static void main(String args[]) {
        Employee1 emp1 = new Employee1("Chan Tai Man", 12000);
        Employee1 emp2 = new Employee1("Tam Ping Shing", 13500);

        System.out.println("Before:");
        System.out.println("Employee1: name=" + emp1.getName() + " salary=" + emp1.getSalary());
        System.out.println("Employee2: name=" + emp2.getName() + " salary=" + emp2.getSalary());

        emp1.setSalary((int)(emp1.getSalary() * 1.1));
        emp2.setSalary((int)(emp2.getSalary() * 1.05));

        System.out.println("After:");
        System.out.println("Employee1: name=" + emp1.getName() + " salary=" + emp1.getSalary());
        System.out.println("Employee2: name=" + emp2.getName() + " salary=" + emp2.getSalary());
    }
}

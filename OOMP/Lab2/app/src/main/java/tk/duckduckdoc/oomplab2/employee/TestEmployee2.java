package tk.duckduckdoc.oomplab2.employee;

public class TestEmployee2 {
    public static void main(String args[]){
        Employee2 emp1 = new Employee2("CHAN Tai Man", 12000);
        Employee2 emp2 = new Employee2("CHAN Ping Shing", 13500);

        System.out.println("Employee 1: name = " + displayDetails(emp1));
        System.out.println("Employee 2: name = " + displayDetails(emp2));

        emp1.raiseSalary(1.05);
        emp2.raiseSalary(1.1);

        System.out.println("Employee 1: name = " + displayDetails(emp1));
        System.out.println("Employee 2: name = " + displayDetails(emp2));

    }

    public static String displayDetails(Employee2 emp){
        return "name = " + emp.getName() + "salary = " + emp.getSalary();
    }

}

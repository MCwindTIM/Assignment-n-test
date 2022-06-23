package tk.duckduckdoc.oomplab4;

public class ParttimeStaff extends Staff implements Salary {
    int workinghour;

    public ParttimeStaff(String name, int id, char grade, int workinghour) {
        super(name, id, grade);
        this.workinghour = workinghour;
    }

    public void display() {
        System.out.println("Name: " + this.name + ", StaffID: " + this.id + ", Grade: " + this.grade + ", Salary: $" + this.computeSalary() + ", Working Hour: " + this.workinghour);
    }

    public int computeSalary() {
        switch(grade){
            case 'A': return salary_A;
            case 'B': return salary_B;
            case 'C': return salary_C;
            default: return salary_other;
        }
    }
}

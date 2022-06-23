package tk.duckduckdoc.oomplab3;

public class Student {
    protected String name;
    protected int student_id;
    protected int year;

    public Student(String name, int student_id, int year){
        this.name = name;
        this.student_id = student_id;
        setYear(year);
    }

    public String toString() {
        return "Name: " + name + ", Student Id: " +
                student_id + ", Year: " + year;
    }

    public void setYear(int year) {
        if (year > 0 && year <= 3)
            this.year = year;
        else {
            System.out.println("Wrong input! Year will be set to 1!");
            this.year = 1;
        }
    }
}

package tk.duckduckdoc.oomplab3;

public class TestStudent {
    public static void main(String args[]) {
        Student student1 = new Student("Ben", 123, 2);
        System.out.println(student1);
        Student student2 = new Student("John", 113, 6);
        System.out.println(student2);
        OutstandingStudent o_stud1 = new OutstandingStudent ("Mary", 456, 3, "academic");
        System.out.println(o_stud1);
        OutstandingStudent o_stud2 = new OutstandingStudent ("Peter", 564, 7, "sports");
        System.out.println(o_stud2);
    }
}

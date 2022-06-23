package tk.duckduckdoc.oomplab2.student;

public class TestStudent2 {
    public static void main(String s[]) {
        Student2 stud1 = new Student2();
        Student2 stud2 = new Student2();
        stud1.setName("Chan Tai Man");
        stud1.setAge(19);
        stud2.setName("Ng Hing");
        stud2.setAge(-23);
        System.out.println("Student: name="+stud1.getName() + ", age=" + stud1.getAge());
        System.out.println("Student: name="+stud2.getName() + ", age=" + stud2.getAge());

        //Q3(a)
        //Student: name=Chan Tai Man, age=19
        //Student: name=Ng Hing, age=-23
        //Q3(b)i
        //age should not under 0
        //Q3(b)ii --in Student2.java
    }
}

package tk.duckduckdoc.oomplab2.student;

public class Test_Driver {
    public static void main(String args[]){
        Student1 stud1 = new Student1("Cheung Siu Ming", 310567, 87.1);
        Student1 stud2 = new Student1("Ng Wai Man", 451267, 77.5);
        Student1 stud3 = new Student1("Wong Sui Kai", 789014, 83.4);

        System.out.println("Student 1: name=" + stud1.getName() + " id=" + stud1.getId() + " score=" + stud1.getScore());
        System.out.println("Student 2: name=" + stud2.getName() + " id=" + stud2.getId() + " score=" + stud2.getScore());
        System.out.println("Student 3: name=" + stud3.getName() + " id=" + stud3.getId() + " score=" + stud3.getScore());

        System.out.println("\nAverage Score = " + ((stud1.getScore() + stud2.getScore() + stud3.getScore()) / 3));

    }
}

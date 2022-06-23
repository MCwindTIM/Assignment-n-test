package tk.duckduckdoc.oomplab4;

public abstract class Staff {
    String name;
    int id, salary;
    char grade;
    public Staff (String name,
                  int id, char grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public abstract void display();
}

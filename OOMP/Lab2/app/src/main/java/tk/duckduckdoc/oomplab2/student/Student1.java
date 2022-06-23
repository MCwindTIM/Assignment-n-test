package tk.duckduckdoc.oomplab2.student;

public class Student1 {
    private String name;
    private int id;
    private double score;

    public Student1(String name, int id, double score){
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setScore(double score){
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public double getScore(){
        return this.score;
    }
}

package tk.duckduckdoc.oomplab3;

public class OutstandingStudent extends Student {
    protected String award;

    public OutstandingStudent(String name, int student_id, int year, String award){
        super(name, student_id, year);
        this.award = award;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Student Id: " + this.student_id + ", Award: " + this.award;
    }
}

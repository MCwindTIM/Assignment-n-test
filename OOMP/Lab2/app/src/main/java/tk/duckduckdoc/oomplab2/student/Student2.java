package tk.duckduckdoc.oomplab2.student;

public class Student2 {
    private String name;
    private int age;
    public void setName(String inName){
        name = inName;
    }
    public String getName(){
        return name;
    }
    //Q3(b)ii
    public void setAge(int age){
        if(age <= 0){
            age = 18;
        }
        this.age = age;
    }
    //end of Q3(b)ii
    public int getAge(){
        return this.age;
    }
}

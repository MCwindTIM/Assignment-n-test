package tk.duckduckdoc.oomplab3;

public class Worker {
    private String name;
    protected double salary;

    public Worker(String inName ){
        name = inName;
    }

    public double earnings(){ return salary; }

    public String toString(){ return name; }
}
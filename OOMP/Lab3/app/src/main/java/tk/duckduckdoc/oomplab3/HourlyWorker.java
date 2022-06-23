package tk.duckduckdoc.oomplab3;

public class HourlyWorker extends Worker {
    private double wage , hours;

    public HourlyWorker(String name, double w, double h ) {
        super( name);
        setWage( w );
        setHours( h );
    }

    public void setWage(double w ) { wage =  w ; }

    public void setHours(double h ){ hours = h ; }

    public double earnings() {
        salary = wage * hours;
        return salary;
    }
}

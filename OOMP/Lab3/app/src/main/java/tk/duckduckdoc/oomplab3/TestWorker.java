package tk.duckduckdoc.oomplab3;

public class TestWorker {
    public static void main(String[] args) {

        Worker[] w = new Worker[2];
        w[0] = new CommissionWorker("John", 120, 10);
        w[1] = new HourlyWorker("Peter", 25, 40);

        // Part (i) - Print original earnings
        System.out.println("Original earning: \n" + w[0].toString() + " earned $" + w[0].earnings() + "\n" + w[1].toString() + " earned $" + w[1].earnings());

        // Part (ii) - Set new values to class members
        ((CommissionWorker)w[0]).setCommission(150);
        ((HourlyWorker)w[1]).setWage(30);
        ((HourlyWorker)w[1]).setHours(50);


        // Part (iii) - Print new earnings
        System.out.println("New earning: ");
        for(int i = 0; i < w.length; i++){
            System.out.println(w[i] + " earned $" + w[i].earnings());
        }

    }
}
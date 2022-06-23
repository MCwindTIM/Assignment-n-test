package tk.duckduckdoc.oomplab3;

public class TestFood2 {
    public static void main(String s[]) {
        Food[] f = new Food[3];
        f[0] = new Food("Rice", 3);
        f[1] = new Drink("Pepsi", 7, 250);
        f[2] = new Coffee("Cappuccino", 13, 200, true);

        for(int i = 0; i < f.length; i++){
            System.out.println("Food " + (i+1) + ": " + f[i].toString());
        }
        //System.out.println("Food 1: " + f1);
        //System.out.println("Food 2: " + f2);
        //System.out.println("Food 3: " + f3);
    }
}

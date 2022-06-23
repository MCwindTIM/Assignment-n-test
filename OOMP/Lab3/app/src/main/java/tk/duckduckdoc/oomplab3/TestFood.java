package tk.duckduckdoc.oomplab3;

public class TestFood {
    public static void main(String s[]) {
        Food f1 = new Food("Rice", 3);
        Food f2 = new Drink("Pepsi", 7, 250);
        Food f3 = new Coffee("Cappuccino", 13, 200, true);

        System.out.println("Food 1: " + f1);
        System.out.println("Food 2: " + f2);
        System.out.println("Food 3: " + f3);
    }
}

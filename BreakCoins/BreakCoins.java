import java.util.Scanner;

public class BreakCoins {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int amount;
        int coins10, coins5, coins2, coins1;

        System.out.print("Input an amount: ");
        amount = input.nextInt();

        coins10 = amount / 10;
        coins5 = (amount % 10) / 5;
        coins2 = (amount % 5) / 2;
        coins1 = amount - (10 * coins10) - (5 * coins5) - (2 * coins2);

        System.out.println("The minimum number of coins for " + amount + "dollars are:");
        System.out.println("10-dollar coin(s): " + coins10);
        System.out.println("5-dollar coin(s): " + coins5);
        System.out.println("2-dollar coin(s): " + coins2);
        System.out.println("1-dollar coin(s): " + coins1);

    }
}
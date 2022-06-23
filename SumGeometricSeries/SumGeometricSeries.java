import java.util.Scanner;

public class SumGeometricSeries {
    public static void main ( String[] args ) {
        Scanner input = new Scanner(System.in);
        double a, r, n, s;

        System.out.print("Enter a : ");
        a = input.nextDouble();

        System.out.print("Enter r : ");
        r = input.nextDouble();

        System.out.print("Enter n : ");
        n = input.nextDouble();
        s = a * ( Math.pow( r, n ) - 1 ) / (r - 1);

        System.out.println("S=" + s);
    }
}
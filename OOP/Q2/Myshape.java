import java.util.InputMismatchException;
import java.util.Scanner;

public class MyShapes {
	public  static void main (String args[]) {
		System.out.print("How many Shapes you would like to create? ");
		int input, i = 0;
		int[][][] shapeinput = new int[100][100][100] ;
		int[] choice = new int[100];
		boolean error = false;
		do {
			error = false;
			Scanner scanner = new Scanner(System.in);
			try {
					i = scanner.nextInt();
			}catch( InputMismatchException ime){
				System.out.println("Please input a vaild value!");
				error = true;
			}
		}while(error);
		
		for(int l = 1; l <= i; l++) {
			System.out.print(l + "." + " What shape you would like to create (1: Square, 2: Rectangle, 3: Circle)? ");
			Scanner scanner = new Scanner(System.in);
					choice[l] = scanner.nextInt();
			if(choice[l] == 1) {
				System.out.print("Please input x: ");
				shapeinput[l][choice[l]][0] = scanner.nextInt();
				System.out.print("Please input y: ");
				shapeinput[l][choice[l]][1] = scanner.nextInt();
				System.out.print("Please input length: ");
				shapeinput[l][choice[l]][2] = scanner.nextInt();
			}
			if(choice[l] == 2) {
				System.out.print("Please input x: ");
				shapeinput[l][choice[l]][0] = scanner.nextInt();
				System.out.print("Please input y: ");
				shapeinput[l][choice[l]][1] = scanner.nextInt();
				System.out.print("Please input width: ");
				shapeinput[l][choice[l]][2] = scanner.nextInt();
				System.out.print("Please input height: ");
				shapeinput[l][choice[l]][3] = scanner.nextInt();
			}
			if(choice[l] == 3) {
				System.out.print("Please input x: ");
				shapeinput[l][choice[l]][0] = scanner.nextInt();
				System.out.print("Please input y: ");
				shapeinput[l][choice[l]][1] = scanner.nextInt();
				System.out.print("Please input radius: ");
				shapeinput[l][choice[l]][2] = scanner.nextInt();
			}
		}
		System.out.println(i + " Shapes are created:");
		double perimeter = 0;
		double area = 0;
		for(int s = 1; s<=i;s++) {
			if(choice[s] == 1) {
				int calc1 = shapeinput[s][choice[s]][2]*4;
				int calc2 = shapeinput[s][choice[s]][2]*shapeinput[s][choice[s]][2];
				perimeter += shapeinput[s][choice[s]][2]*4;
				area += shapeinput[s][choice[s]][2]*shapeinput[s][choice[s]][2];
				System.out.println("Square at (" + shapeinput[s][choice[s]][0]+","+shapeinput[s][choice[s]][1]+"): Length = " + shapeinput[s][choice[s]][2] + ", the perimeter is " + calc1 + " and area is " + calc2);
			}
			if(choice[s] == 2) {
				perimeter += ((2*shapeinput[s][choice[s]][2]+2*shapeinput[s][choice[s]][3]));
				area += shapeinput[s][choice[s]][2]*shapeinput[s][choice[s]][3];
				System.out.println("Rectangle at (" + shapeinput[s][choice[s]][0] + "," + shapeinput[s][choice[s]][1] + "): Width = " + shapeinput[s][choice[s]][2] + ", height = " + shapeinput[s][choice[s]][3] + ", the perimeter is " + (2*shapeinput[s][choice[s]][2]+2*shapeinput[s][choice[s]][3]) + " and area is " + shapeinput[s][choice[s]][2]*shapeinput[s][choice[s]][3]);
			}
			if(choice[s] == 3) {
				perimeter += 2*Math.PI*shapeinput[s][choice[s]][2];
				area += Math.pow(shapeinput[s][choice[s]][2], 2)*Math.PI;
				System.out.println("Circle at (" + shapeinput[s][choice[s]][0] + "," + shapeinput[s][choice[s]][1] + "): Radius = " + shapeinput[s][choice[s]][2] + ", the perimeter is " + round(2*Math.PI*shapeinput[s][choice[s]][2], 2) + " and area is " + round(Math.pow(shapeinput[s][choice[s]][2], 2)*Math.PI, 2));
			}
		}
		System.out.println("The total perimeter is " + round(perimeter, 2));
		System.out.println("The total area is " + round(area, 2));
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}

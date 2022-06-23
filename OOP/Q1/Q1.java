package Q1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1 {

	public static void main (String args[]) {
		boolean error = false;
		int i = 0;
		do {
			error = false;
			Scanner sc = new Scanner(System.in);
		try {
			i = sc.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("int error!");
			error = true;
		}
		}while(error);
		System.out.println("The input is: " + i);
	}
	
}

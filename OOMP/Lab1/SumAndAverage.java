public class SumAndAverage {   // saved as "SumAndAverage.java"
   public static void main (String[] args) {
    int sum = 0;          // store the accumulated sum, init to 0
    double average;       // average in double
    int lowerbound = 1;   // the lower bound to sum
    int upperbound = 100; // the upper bound to sum

    for (int number = lowerbound; number <= upperbound; ++number) { // for loop
       sum += number;     // same as "sum = sum + number"
    }
    // Compute average in double. Beware that int/int produces int.
    average = (double) sum / (double) upperbound;
    // Print sum and average.
    System.out.println("The sum is " + sum);
    System.out.println("The average is " + average);
   }
}

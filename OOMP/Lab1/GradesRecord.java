import java.util.Scanner;

public class GradesRecord{
    public static int[] grades;  // Declare an int[], to be allocated later
    
    // main() method
    public static void main(String[] args) {
       readGrades();
       System.out.println("The average is " + average());
       System.out.println("The minimum is " + min());
       System.out.println("The maximum is " + max());
    }
    
    // Prompt user for the number of students and allocate the "grades" array.
    // Then, prompt user for grade, check for valid grade, and store in "grades".
    public static void readGrades() { 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int number = input.nextInt();
        grades = new int[number];
        for (int i = 0; i < number; i++) {
            int grade;
            boolean vaild = false;
           System.out.print("Enter the grade for student " + (i+1) + ": ");
           while(!vaild){
            grade = input.nextInt();
            if(grade > 100 || grade < 0){
                //iuput again (not vaild grade)
            }else{
                grades[i] = grade;
                vaild = true;
            }
           }
        }
        System.out.println();
    }
    
    // Return the average value of int[] grades
    public static double average() { 
        double calc = 0;
        for (int i = 0; i < grades.length; i++){
            calc += grades[i];
        }   
        return calc / grades.length;
    }
    
    // Return the maximum value of int[] grades
    public static int max() { 
        int max = 0;
        for (int i = 0; i < grades.length; i++){
            if( max < grades[i])
                max = grades[i];
        }
        return max;
    }
    
    // Return the minimum value of int[] grades
    public static int min() { 
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < grades.length; i++){
            if( min > grades[i])
                min = grades[i];
        }
        return min;
    }
 }
 
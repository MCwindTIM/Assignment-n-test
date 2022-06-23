/********************************************************
 Program File: Distances.java
 Programmer: 
 Programme: 
 Description: This program is use to calculate longest, shortest and second shortest distance between multiple points.
********************************************************/

import java.io.*;
import java.util.*;
import java.awt.*; // import java awt library

public class Distances {
   
   final static int MAX_NO_POINTS = 19;      // max. number of input points

   public static void main( String[] args ) throws Exception {

      int x[] = new int[MAX_NO_POINTS];      // array to store points' x-coordinates
      int y[] = new int[MAX_NO_POINTS];      // array to store points' y-coordinates
      Point points[] = new Point[MAX_NO_POINTS]; // Point class object array to store point infomation
      int n;                                 // number of points read
      
      n = readPoints( "points.txt", x, y );
      System.out.println("Name: XXXXX\n");
      System.out.println( "Input Points:" );
      String outputString = "";

      //Generate display string to show points in 5 points each line and putting int array "x", "y" information to Point array "points".
      for (int i=0; i<n; i++){
         points[i] = new Point(x[i], y[i]);
         outputString += "(" + x[i] + "," + y[i] + ") ";
         if(i%5 ==4){
            outputString += "\n";
         }
      }
      //display points
      if(outputString.endsWith("\n"))
         System.out.print(outputString + "\n");
      else
         System.out.println(outputString + "\n");

      //display and call method to calculate the infomation about longest/shortest/second shortest distance in multiple points
      System.out.println("The longest distance is " + calc(points[findLongestPath(points)[0]], points[findLongestPath(points)[1]]) + ", between " + p2s(points[findLongestPath(points)[0]]) + " and " + p2s(points[findLongestPath(points)[1]]) + ".");
      System.out.println("The shortest distance is " + calc(points[findShortestPath(points)[0]], points[findShortestPath(points)[1]]) + ", between " + p2s(points[findShortestPath(points)[0]]) + " and " + p2s(points[findShortestPath(points)[1]]) + ".");
      System.out.println("The second shortest distance is " + calc(points[findSecondShortestPath(points)[0]], points[findSecondShortestPath(points)[1]]) + ", between " + p2s(points[findSecondShortestPath(points)[0]]) + " and " + p2s(points[findSecondShortestPath(points)[1]]) + ".");
      
      //System.out.println("\n" + calc(points[15], points[16])); // (temp test calc method) Don't Hardcode

      //Done!
   }

   /***************************************************************************
     This method reads the coordinates of points from a text file.
     Inputs:
        filename : the file name of the input text file
     Outputs:
        x[], y[]  : arrays store coordinates of input points
        e.g. x[0] : stores the x-coordinate of the 1st point
             y[0] : stores the y-coordinate of the 1st point
                  ...
             x[n-1] : stores the x-coordinate of the nth point
             y[n-1] : stores the y-coordinate of the nth point
     Return value:
        the total number of points read from the text file
   ***************************************************************************/
   public static int readPoints( String filename, int[] x, int[] y )
      throws Exception {

      // Create a File instance and a Scanner for the input file
      File inFile = new File( filename );
      Scanner input = new Scanner( inFile );

      // Read coordinates of points from the input file
      int n = 0;                             // number of points read
      while (input.hasNext()) {
         x[n] = input.nextInt();             // read x-coordinate
         y[n] = input.nextInt();             // read y-coordinate
         n++;                                // count number of points
      }

      input.close();                         // close the input file
      return n;                              // return number of points read
   }

/***************************************************************************
   This method is use to convert Point object to display string
***************************************************************************/
  public static String p2s(Point x){
      return "(" + x.x + "," + x.y + ")";
   }

/***************************************************************************
   This method is use to calculate distance between 2 points
***************************************************************************/
  public static int calc(Point x, Point y) {
      return (int)Math.sqrt(Math.pow(x.x - y.x, 2) + Math.pow(x.y - y.y, 2));
   }

/***************************************************************************
This method is use to findout Longest path between multiple points
***************************************************************************/
   public static int[] findLongestPath(Point[] coordinates){
      int length = findArrayLength(coordinates);
      double dblLongestDistance = 0;
      int[] intLongestDistancePointPos = new int[2]; // use to store longest path between two points's position in Point[];

      // create 2 for loop to loop through all the points
      for(int i=0;i<length-1;i++){
         for(int j=i+1;j<length;j++){
            double Distance = calc(coordinates[i], coordinates[j]);
            if(Distance > dblLongestDistance){
               dblLongestDistance = Distance;
               intLongestDistancePointPos[0] = i;
               intLongestDistancePointPos[1] = j;
            }
         }
      }

      return intLongestDistancePointPos;
   }

/***************************************************************************
This method is use to findout Shortest path between multiple points
***************************************************************************/
  public static int[] findShortestPath(Point[] coordinates){
      int length = findArrayLength(coordinates);
      double dblShortestDistance = Double.MAX_VALUE;
      int[] intShortestDistancePointPos = new int[2]; // use to store Shortest path between two points's position in Point[];

      // create 2 for loop to loop through all the points
      for(int i=0;i<length-1;i++){
         for(int j=i+1;j<length;j++){
            double Distance = calc(coordinates[i], coordinates[j]);
            //If Distance smaller than cache shortest Distance, Distance become the shortest Distances
            //If Distance = 0, that means there have 2 or more same porint
            if(Distance < dblShortestDistance && Distance != 0){
               dblShortestDistance = Distance;
               intShortestDistancePointPos[0] = i;
               intShortestDistancePointPos[1] = j;
            }
         }
      }
      return intShortestDistancePointPos;
   }

/***************************************************************************
This method is use to findout Second Shortest path between multiple points
***************************************************************************/
   public static int[] findSecondShortestPath(Point[] coordinates){
      // find out shortest path
      int length = findArrayLength(coordinates);
      double dblShortestDistance = Double.MAX_VALUE;

      // create 2 for loop to loop through all the points (find Shortest distance)
      for(int i=0;i<length-1;i++){
         for(int j=i+1;j<length;j++){
            double Distance = calc(coordinates[i], coordinates[j]);
            //If Distance smaller than cache shortest Distance, Distance become the shortest Distances
            //If Distance = 0, that means there have 2 or more same porint
            if(Distance < dblShortestDistance && Distance != 0){
               dblShortestDistance = Distance;
            }
         }
      }

      double dblSecondShortestDistance = Double.MAX_VALUE;
      int[] intSecondShortestDistancePointPos = new int[2]; // use to store Second Shortest path between two points's position in Point[];

      // create 2 for loop to loop through all the points (use shortest distance to find second shorest distance)
      for(int i=0;i<length-1;i++){
         for(int j=i+1;j<length;j++){
            double Distance = calc(coordinates[i], coordinates[j]);
            //If Distance smaller than cache second shortest Distance and larger than shortest Distance, Distance become the second shortest Distances
            if(Distance < dblSecondShortestDistance && Distance > dblShortestDistance){
               dblSecondShortestDistance = Distance;
               intSecondShortestDistancePointPos[0] = i;
               intSecondShortestDistancePointPos[1] = j;
            }
         }
      }

      return intSecondShortestDistancePointPos;
   }

/***************************************************************************
This method is use to findout Point[]'s vaild length (filter null value)
(use to fix null pointer exception when less than 19 points)
***************************************************************************/
  
   public static int findArrayLength(Object[] array){
      int count = 0;
      for (Object point : array) {
         if ( point != null ) count++;
       }
      return count;
   }
}

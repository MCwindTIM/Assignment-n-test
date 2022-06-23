public class PrintTriangle {   // saved as " PrintTriangle.java"
   public static void main (String[] args) {
        int size = 5;    // size of the board
        for (int row = 1; row <= size; row++) {
           for (int col = size; col >= row; col--) {
               System.out.print("#");
           }
           System.out.println();
        }
   }
}
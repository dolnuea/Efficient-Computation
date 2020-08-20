
/**
 * @author Dolunay Dagci
 * CISS 111-360
 * Assignment: Ch17 Efficient Computation
 * Due date: Sunday, April 7, 2019
 * This program compares execution time in milliseconds creating Pascal's triangle using 2 different algorithms: Iteration and Recursion.
 */
public class DD_EfficientComputation {

    public static void main(String[] args) {

        System.out.println("\n***********Recursion Algorithm***********\n");
        //3 n values: 10, 20, and 30. Methods are fixed(1 n parameter)
        RecursionPascal(10);
        RecursionPascal(20);
        RecursionPascal(30);
        System.out.println("\n***********Iteration Algorithm***********\n");
        LoopPascal(10);
        LoopPascal(20);
        LoopPascal(30);
    }

    /***********************
     * Recursion Algorithm *
     ***********************/

    /**
     * @param row rows in Pascal's Triangle
     * @param col columns in Pascal's Triangle
     * @return values in the Pascal's Triangle
     */
    private static int pascalTriangle(int row, int col) {

        if (col == 0 || col == row) return 1; //base case is 0, returns 1
        else
            return pascalTriangle(row - 1, col - 1) + pascalTriangle(row - 1, col); //Recursive formula to create remaining values in Pascal's Triangle.
    }

    /**
     *
     * @param n value: the number of rows that will be n Pascal's Triangle
     */
    private static void RecursionPascal(int n) { //parameter fixed
        long start_time = System.currentTimeMillis(); //start time in milliseconds
        for (int row = 0; row < n; row++) { //make n number of rows
            for (int col = 0; col <= row; col++) { //build the triangle by placing the columns which are incremented one by one every row
                System.out.print(pascalTriangle(row, col) + " "); //put the remaining values in Pascal's Triangle into each line/row
            }
            System.out.println(); //pass to a new line after each row
        }
        long end_time = System.currentTimeMillis(); //end time
        long difference = end_time-start_time;  //get the time passed after triangle(s) are created
        System.out.printf("\nTotal time used to run the algorithm recursion for %d rows of Pascal's Triangle in milliseconds: "+ difference + "\n", n);
    }


    /***********************
     * Iteration Algorithm *
     ***********************/

    /**
     *
     * @param n value: the number of rows that will be n Pascal's Triangle
     */
    public static void LoopPascal(int n) { //parameter fixed
        long start_time = System.currentTimeMillis(); //start time in milliseconds
        int[] previousRow;
        int[] currentRow = {1}; //initial row is 1
        printArray(currentRow);
        previousRow = currentRow;
        for (int i = 2; i <= n; i++) { //n is the number of rows in this triangle
            currentRow = new int[i];
            currentRow[0] = 1; //1st column is always 1
            currentRow[i - 1] = 1; //the last 1st column is always 1
            for (int j = 0; j <= i - 3; j++) { //compute elements of current row
                currentRow[j + 1] = previousRow[j] + previousRow[j + 1];
            }
            printArray(currentRow);
            previousRow = currentRow;
        }
        long end_time = System.currentTimeMillis(); //end time
        long difference = end_time-start_time; //get the time passed after triangle(s) are created
        System.out.printf("\nTotal time used to run the algorithm iteration for %d rows of Pascal's Triangle in milliseconds: "+ difference + "\n", n);

    }

    /**
     *
     * @param array that will be printed
     */
    public static void printArray(int[] array) {
        for (int value : array) System.out.print(value + " ");
        System.out.println();
    }
}

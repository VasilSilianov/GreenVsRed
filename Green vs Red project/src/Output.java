import java.io.PrintStream;

/**
 *  This class is
 */
public class Output {

    private final PrintStream outputStream;

    public Output(PrintStream out) {
        this.outputStream = out;
    }
    /**
     * @param  output integer that represent the result of  greenVsRedAlgorithm
     *          This method is used to print the result of the greenVsRedAlgorithm method
     *          of class Algorithm
     */

 public void OutputOfTheAlgorithm(int output) {
     outputStream.printf("%d", output);
    }

    /**
     *
     * @param arr - two dimensional array that represents the grid
     * This method prints two dimensional array.
     * I used it while I was testing the algorithm
     * to check the generations.
     *  It is static so that can be  used without instantiating
     */

    public static void printArr(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }
}
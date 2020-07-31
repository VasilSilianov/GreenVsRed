import java.io.InputStream;
import java.util.Scanner;

/**
 * This class takes care of the input of the program
 */
public class Input {
    /**
     * @param x,y dimensions  of the grid  where y is number of rows and x number of columns
     */
    private int x, y;
    /**
     * @param arr two dimensional array that represents the grid
     */
    private int[][] arr;
    /**
     * @param y1 input for the row of the searched element
     * @param x1 input for the column of the searched element
     * @param N - number of generations
     *          I have used the naming convention of the task
     */
    private int x1, y1,N;

    public Input(InputStream inputStream) {
        Scanner input = new Scanner(inputStream);
        initializeArrDimensions(input);
        initializeTheGrid(input);
        initializeCoordinatesAndGenerations(input);
    }


    /**
     *
     * @param  input input stream to read from the console
     * This method initialize x and y parameters and
     * creates  new array  with dimensions[y][x],
     * where y is the number of  rows
     * and x is the number of elements on each row.
     */
    private void initializeArrDimensions(Scanner input){
        String[] arrDimensions = input.nextLine().split(", ");
        setX(Integer.parseInt(arrDimensions[0]));
        setY(Integer.parseInt(arrDimensions[1]));
        this.arr = new int[getY()][getX()];
    }

    /**
     *
     * @param input input stream to read from the console
     * This method initialize every position in the
     *  Grid(arr).
     */

    private void initializeTheGrid(Scanner input){
        for (int i = 0; i < getY(); i++) {
            String[] strArr = input.nextLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                setValue(Integer.parseInt(strArr[j]),i,j);
            }
        }
    }

    /**
     *
     * @param input input stream to read from the console
     * This method initialize x1, y1, and N, where:
     * y1 is the row  of the element we are looking for,
     * x1 is the specific position in the row of the element,
     * And N is the number of  generations.
     */
    private  void initializeCoordinatesAndGenerations(Scanner input){
        String[] instructions = input.nextLine().split(", ");
        setX1(Integer.parseInt(instructions[0]));
        setY1(Integer.parseInt(instructions[1]));
        setN(Integer.parseInt(instructions[2]));

    }

    // setters and getters

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public int[][] getArr() {
        return arr;
    }

    protected void setValue(int value, int x, int y) {
        this.arr[x][y] = value;
    }

    public int getX1() {
        return x1;
    }

    protected void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    protected void setY1(int y1) {
        this.y1 = y1;
    }

    public int getN() {
        return N;
    }

    protected void setN(int n) {
        N = n;
    }


}

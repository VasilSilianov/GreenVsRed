import java.util.Scanner;

public class inputOOP {
    private int x;
    private int y;
    private int[][] arr;
    private int x1;
    private int y1;
    private int N;

    public inputOOP(Scanner input) {
            initializeArrDimensions(input);
            initializeTheGrid(input);
            initializeCoordinatesAndGenerations(input);
    }

    public void initializeArrDimensions(Scanner input){
        String[] arrDimensions = input.nextLine().split(", ");
        setX(Integer.parseInt(arrDimensions[0]));
        setY(Integer.parseInt(arrDimensions[1]));
        this.arr = new int[getY()][getX()];
    }

    public void initializeTheGrid(Scanner input){
        for (int i = 0; i < getY(); i++) {
            String[] strArr = input.nextLine().split("");
            for (int j = 0; j < strArr.length; j++) {
                setValue(Integer.parseInt(strArr[j]),i,j);
            }
        }
    }

    public  void initializeCoordinatesAndGenerations(Scanner input){
        String[] instructions = input.nextLine().split(", ");
        setX1(Integer.parseInt(instructions[0]));
        setY1(Integer.parseInt(instructions[1]));
        setN(Integer.parseInt(instructions[2]));

    }

    /**
     *
     * @param arr
     */
    public static void printArr(int[][] arr) {
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
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
        this.arr[y][x] = value;
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

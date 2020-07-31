/**
 *
 * This class represents the algorithm of the program
 */
public class Algorithm {

    /**
     * @param arr two demensional array that represents the grid
     * @param y1 the row of the searched element
     * @param x1 the column of the searched element
     * @param N number of generations
     * @return the number of time that the searched cell was green
     * This method calculate the next generation of the grid from
     * the current generation of the grid by applying method:
     * rule1and2 and rule3and4
     */
    public int greenVsRedAlgorithm(int[][] arr, int y1, int x1, int N) {
        int counter = 0;
        if (arr[y1][x1] == 1) {
            counter++;
        }

        for (int i = 0; i < N; i++) {
            int[][] nextGenArr = copyArr(arr);
            rule1and2(arr, nextGenArr);
            arr = rule3and4(arr, nextGenArr);
            if (arr[y1][x1] == 1) {
                counter++;
            }
        }
        return counter;
    }

    /**
     *
     * @param arr grid for cloning
     * @return deep clone
     * Creates new array with same values ... //TODO
     */
    private int[][] copyArr(int[][] arr) {
        int[][] copiedArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copiedArr[i][j] = arr[i][j];
            }
        }
        return copiedArr;
    }

    /**
     *
     * @param currentGen current generation grid
     * @param nextGen next generation grid
     * @return the next generation array.
     * Takes the current generation array
     * and applies and the next generation array
     * rules :
     * One Each red cell that is surrounded by exactly 3 or exactly 6 green cells will also become green in the next generation
     * Two A red cell will stay red in  the next generation if it has either 0,1,2,4,5,7 or 8 green neighbours.
     *
     */
    private void rule1and2(int[][] currentGen, int[][] nextGen) {
        for (int i = 0; i < currentGen.length; i++) {
            for (int j = 0; j < currentGen[i].length; j++) {
                //int sum = 0;
                if (currentGen[i][j] == 0) {
                    int sum = whichCase(currentGen, j, i);
                    if (sum == 3 || sum == 6) {
                        nextGen[i][j] = 1;
                    }
                }
            }
        }
    }

    /**
     *
     * @param currentGen current generation grid
     * @param nextGen next generation grid
     * @return the next generation array.
     * Takes the current generation array
     * and applies and the next generation array
     * rules:
     * Tree Each green cell surrounded by 0,1,4,5,7 or 8 green neighbours will become red in the next generation
     * Four A green cell will stay green in the next generation if it has either 2,3 or 6 green neighbours.
     */
    private int[][] rule3and4(int[][] currentGen, int[][] nextGen) {
        for (int i = 0; i < currentGen.length; i++) {
            for (int j = 0; j < currentGen[i].length; j++) {
                if (currentGen[i][j] == 1) {
                    int sum = whichCase(currentGen, j, i);
                    if (!(sum == 3 || sum == 6 || sum == 2)) {
                        nextGen[i][j] = 0;
                    }
                }
            }
        }
        return nextGen;
    }

    /**
     *
     * @param arr the generation we look into
     * @param x1 is the row of the searched element
     * @param y1 is the column of the searched element
     * @return the sum of all cells around the (x1,y1) cell
     * This method check in which case (edge, side or inside position in the grid)
     *  and calculates the sum of all the surrounding cells
      */
    private int whichCase(int[][] arr, int x1, int y1) {
        int sum = 0;
        if (x1 == 0 && y1 == 0) { //edge case
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == arr.length - 1) { //edge case
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1][x1 - 1];
        } else if (x1 == 0 && y1 == arr.length - 1) { //edge case
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == 0) {//edge case
            sum += arr[y1][x1 - 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
        } else if (x1 == 0) { //side case
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1) { //side case
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 - 1];
        } else if (y1 == 0) { //side case
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (y1 == arr.length - 1) { //side case
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else { // inside position case
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        }
        return sum;
    }
}

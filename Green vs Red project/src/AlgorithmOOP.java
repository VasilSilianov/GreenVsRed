public class AlgorithmOOP {

    public int Algorithm(int[][] arr, int y1, int x1, int N) {
        int counter = 0;
        if (arr[y1][x1] == 1) {
            counter++;
        }
        for (int i = 0; i < N; i++) {
            int[][] nextGenArr = copyArr(arr);
            nextGenArr = rule1and2(arr, nextGenArr);
            arr = rule3and4(arr, nextGenArr);
            if (arr[y1][x1] == 1) {
                counter++;
            }
        }
        return counter;
    }

    private int[][] copyArr(int[][] arr) {
        int[][] copiedArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copiedArr[i][j] = arr[i][j];
            }
        }
        return copiedArr;
    }

    private int[][] rule1and2(int[][] arr, int[][] nextGen) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //int sum = 0;
                if (arr[i][j] == 0) {
                    int sum = whichCase(arr, j, i);
                    if (sum == 3 || sum == 6) {
                        nextGen[i][j] = 1;
                    }
                }
            }
        }
        return nextGen;
    }

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

    private int whichCase(int[][] arr, int x1, int y1) {
        int sum = 0;
        if (x1 == 0 && y1 == 0) {
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == arr.length - 1) {
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1][x1 - 1];
        } else if (x1 == 0 && y1 == arr.length - 1) {
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == 0) {
            sum += arr[y1][x1 - 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
        } else if (x1 == 0) {
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1) {
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 - 1];
        } else if (y1 == 0) {
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (y1 == arr.length - 1) {
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else {
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

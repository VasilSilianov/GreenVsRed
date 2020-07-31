import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Algorithm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] arrDimensions = input.nextLine().split(", ");

        int y = Integer.parseInt(arrDimensions[1]);
        int x = Integer.parseInt(arrDimensions[0]);

        int[][] arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            String strArr[] = input.nextLine().split("");

            for (int j = 0; j < strArr.length; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        String[] instructions = input.nextLine().split(", ");
        int x1 = Integer.parseInt(instructions[0]);
        int y1 = Integer.parseInt(instructions[1]);
        int N = Integer.parseInt(instructions[2]);

        int counter = 0;
        if (arr[y1][x1] == 1) {
            counter++;
        }
        for (int i = 0; i < N; i++) {
            //System.out.println("here + 0");
            int[][] nextGenArr= copyArr(arr);
            nextGenArr = rule1and2(arr,nextGenArr);
            arr = rule3and4(arr,nextGenArr);
            System.out.println("next generation"+ (i+1));
            printArr(arr);
            System.out.println();

            if (arr[y1][x1] == 1) {
                counter++;
            }
        }

        System.out.println(counter);

        //  System.out.println(N + "tova e N");
        // first  chek position

/*
        if (x1 == 0 && y1 == 0) {
            //todo something1
            System.out.println(" x1 == 0 && y1 == 0 ");
        } else if (x1 == x - 1 && y1 == y - 1) {
            // todo something2
            System.out.println(" x1 == x - 1 && y1 == y - 1 ");
        } else if (x1 == 0 && y1 == y - 1) {
            // todo something3
            System.out.println(" x1 == 0 && y1 == y - 1 ");

        } else if (x1 == x - 1 && y1 == 0) {
            // todo something4
            System.out.println(" x1 == x - 1 && y1 == 0 ");

        } else if (x1 == 0) {
            // todo something5
            System.out.println(" x1 ==0 ");

        } else if (x1 == x - 1) {
            // todo something6
            System.out.println(" x1 == x-1 ");

        } else if (y1 == 0) {

            int counter = 0;
            //  System.out.println("initialValue: " + initialValue);
            for (int i = 0; i < N; i++) {

                if (arr[y1][x1] == 0) {
                    int sum = 0;
                    sum += arr[y1][x1];
                    sum += arr[y1][x1 - 1];
                    sum += arr[y1][x1 + 1];
                    sum += arr[y1 + 1][x1 - 1];
                    sum += arr[y1 + 1][x1];
                    sum += arr[y1 + 1][x1 + 1];
                    if (sum == 3 || sum == 6) {
                        arr[y1][x1] = 1;

                        //   System.out.println("here 1");
                        //counter++;
                    }
                } else {
                    counter++;
                    int sum = 0;
                    sum += arr[y1][x1];
                    sum += arr[y1][x1 - 1];
                    sum += arr[y1][x1 + 1];
                    sum += arr[y1 + 1][x1 - 1];
                    sum += arr[y1 + 1][x1];
                    sum += arr[y1 + 1][x1 + 1];
                    if (!(sum == 2 || sum == 3 || sum == 6)) {

                        arr[y1][x1] = 0;

                        //  System.out.println("here 2");
                    }

                }

            }

            System.out.println("counter: " + counter);

        } else if (y1 == y - 1) {
            // todo something8
            System.out.println(" y1 == y-1 ");

        } else {
            System.out.println("here");
            int counter = 0;
            //  System.out.println("initialValue: " + initialValue);
            if (arr[y1][x1] == 1) {
                counter++;
            }
            for (int i = 0; i < N; i++) {
                //System.out.println("here + 0");
                rule1and2(arr);
                rule3and4(arr);

                if (arr[y1][x1] == 1) {
                    counter++;
                }
            }

            System.out.println("counter: " + counter);

        }*/

    }


    public static int[][] rule1and2(int[][] arr,int[][] nextGen) {
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

    public static int[][] rule3and4(int[][] currentGen, int[][] nextGen) {
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

    public static int whichCase(int[][] arr, int x1, int y1) {
        // first  chek position
        int sum = 0;
        if (x1 == 0 && y1 == 0) {
        //    System.out.println("where are we 2");
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == arr.length - 1) {
         //   System.out.println("where are we 3");
            sum += arr[y1 - 1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1][x1 - 1];
        } else if (x1 == 0 && y1 == arr.length - 1) {
         //   System.out.println("where are we 4");
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1 && y1 == 0) {//tuk li mi e greshkata
        //    System.out.println("where are we 5");
            sum += arr[y1][x1 - 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
        } else if (x1 == 0) {
       //     System.out.println("where are we 6");
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 + 1];
        } else if (x1 == arr[0].length - 1) {
       //     System.out.println("where are we 7");
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1][x1 - 1];
            sum += arr[y1 - 1][x1];
            sum += arr[y1 - 1][x1 - 1];
        } else if (y1 == 0) {
         //   System.out.println("where are we 8");
            sum += arr[y1][x1 - 1];
            sum += arr[y1][x1 + 1];
            sum += arr[y1 + 1][x1 - 1];
            sum += arr[y1 + 1][x1];
            sum += arr[y1 + 1][x1 + 1];
        } else if (y1 == arr.length - 1) {
    //        System.out.println("where are we 9");
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
      //      System.out.println("where are we 1");
        }

        return sum;
    }


    public static void printArr(int[][] arr) {

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] copyArr( int[][] arr){
        int[][] copiedArr= new int [arr.length][arr[0].length];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                copiedArr[i][j] = arr[i][j];
            }
        }
        return copiedArr;
    }
}

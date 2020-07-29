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

      //  System.out.println(N + "tova e N");
        // first  chek position


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

        } else if (x1 ==0){
            // todo something5
            System.out.println(" x1 ==0 ");

        } else if (x1 == x-1){
            // todo something6
            System.out.println(" x1 == x-1 ");

        } else if (y1 == 0){
            // todo something7  tu rabotim

            int counter = 0;
          //  System.out.println("initialValue: " + initialValue);
            for (int i = 0; i <N; i++) {

            if (arr[y1] [x1] == 0){
                int sum = 0;
                sum+= arr[y1][x1];
                sum+= arr[y1][x1-1];
                sum+= arr[y1][x1+1];
                sum+= arr[y1+1][x1-1];
                sum+= arr[y1+1][x1];
                sum+= arr[y1+1][x1+1];
                if (sum ==3 || sum == 6){
                    arr[y1] [x1] = 1;

                 //   System.out.println("here 1");
                    //counter++;
                }
            }else {
                counter++;
                int sum =0;
                sum+= arr[y1][x1];
                sum+= arr[y1][x1-1];
                sum+= arr[y1][x1+1];
                sum+= arr[y1+1][x1-1];
                sum+= arr[y1+1][x1];
                sum+= arr[y1+1][x1+1];
                if ( !(sum == 2|| sum ==3 || sum == 6)){

                    arr[y1] [x1] = 0;

                  //  System.out.println("here 2");
                }

            }

        }

            System.out.println( "counter: " + counter);

        } else if (y1 == y-1){
            // todo something8
            System.out.println(" y1 == y-1 ");

        }else {
            // todo something9
            System.out.println(" else ");

        }

    }
}

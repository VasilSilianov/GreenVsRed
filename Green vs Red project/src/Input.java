import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] arrDimensions = input.nextLine().split(", ");

        //  System.out.println(" Enter height (y):");
        //  System.out.println(" Enter width (x):");
//            int x =input.nextInt();
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

        // print for test
        System.out.println(arr.length + "  " + arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println(x1 + " " + y1 + " " + N);
    }

}

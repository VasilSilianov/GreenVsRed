import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreenVsRedTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        inputOOP newInputOOP = new inputOOP(input);


        System.out.println(newInputOOP.getX() + " " + newInputOOP.getY()) ;
//        ArrayList<Integer>[] list = new ArrayList<>();
        inputOOP.printArr(newInputOOP.getArr());
        System.out.println(newInputOOP.getX1() + " " +newInputOOP.getY1() + " "+newInputOOP.getN() + " ");


    }
}

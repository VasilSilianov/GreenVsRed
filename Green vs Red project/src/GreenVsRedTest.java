/**
 * This class is test class
 * where we can test our program
 */
public class GreenVsRedTest {
    public static void main(String[] args) {

        Input newInput = new Input(System.in);
        Algorithm algorithm = new Algorithm();
        Output newOutput = new Output(System.out);
        newOutput.OutputOfTheAlgorithm(
                algorithm.greenVsRedAlgorithm(
                        newInput.getArr(),
                        newInput.getY1(),
                        newInput.getX1(),
                        newInput.getN())
        );

        /**
         * Test cases I've worked with
         * 3, 3
         * 000
         * 111
         * 000
         * 1, 0, 10
         *
         * 3, 3
         * 000
         * 111
         * 000
         * 1, 1, 10
         *
         * 3, 3
         * 000
         * 111
         * 000
         * 2, 2, 10
         *
         * 4, 4
         * 1001
         * 1111
         * 0100
         * 1010
         * 2, 2, 15
         */
    }
}

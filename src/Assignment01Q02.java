public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int loopEnd = Integer.parseInt(args[0]);
        for (int i = 0; i < loopEnd; i++) {

            double currentTerm = 1d / (double) (2 * i + 1);
            if (i % 2 == 1) {
                currentTerm *= -1d;
            }

            approxPi += currentTerm;
        }
        approxPi *= 4;

        System.out.println(approxPi + " " + actualPi);
    }
}

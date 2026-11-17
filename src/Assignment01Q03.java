public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int first = 1, second = 1;
        int numOdd = 2;
        System.out.print("1 1");
        for (int i = 2; i < x; i++) {
            int result = first + second;
            System.out.print(" " + result);
            if (result % 2 == 1) {
                numOdd++;
            }

            first = second;
            second = result;
        }
        System.out.println();

        System.out.println("The number of odd numbers is: " + numOdd);
    }
}

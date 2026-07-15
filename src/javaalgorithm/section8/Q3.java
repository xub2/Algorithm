package javaalgorithm.section8;

import java.util.Scanner;

public class Q3 {

    private static int factorial(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(factorial(sc.nextInt()));
    }
}

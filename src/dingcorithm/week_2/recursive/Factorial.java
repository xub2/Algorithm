package dingcorithm.week_2.recursive;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        int n = 5;

        System.out.println(factorial(n));
    }

    private static int factorial(int number) {

        if (number == 1) { // 0보다 작거나 같다 = 0, -1 ...
            return 1;
        }

        return number * factorial(number - 1);
    }

}

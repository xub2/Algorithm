package dingcorithm.week_2.recursive;

import java.util.Scanner;

public class PalindromeV3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(isPalindromeRecursive(input));
    }

    private static boolean isPalindromeRecursive(String input) {
        char[] inputToCharArray = input.toCharArray();

        if (inputToCharArray[0] != inputToCharArray[input.length() - 1]) {
            return false;
        }

        if (input.length() <= 1) {
            return true;
        }

        return isPalindromeRecursive(input.substring(1, input.length() - 1));
        }
    }
